
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceInterface extends Remote {

    public String sayHello() throws RemoteException;

    public int login() throws RemoteException;

    public int jogar(int ricardo, int paulo, int as) throws RemoteException;

    public int vez() throws RemoteException;

    public void fill() throws RemoteException;

    public String[][] vertab() throws RemoteException;

    public int winner() throws RemoteException;

    public int njog() throws RemoteException;
}
