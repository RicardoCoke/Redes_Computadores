
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor {

    public static void main(String[] args) {

        Service service = new Service();
        try {
            ServiceInterface stub = (ServiceInterface) UnicastRemoteObject.exportObject(service, 0);
            Registry reg = LocateRegistry.createRegistry(3100);
            reg.bind("galinha", stub);
            //while(true);
            for (;;) {
                Thread.sleep(10000);
            }
            






        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
