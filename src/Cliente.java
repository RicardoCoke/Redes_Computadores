
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente {

    public static void main(String[] args) throws RemoteException {
        try {

            Registry reg = LocateRegistry.getRegistry("localhost", 3100);
            Remote r = reg.lookup("galinha");
            ServiceInterface service = (ServiceInterface) r;

            service.fill();
            int winner = service.winner();
            int log = service.login();
            System.out.println("Você é o jogador numero:" + (log));
            int vez = service.vez();
         int j=0;
            while (winner != 1 && winner != 0 && winner != (-2)) {
                if (log == 4) {

                    Thread.sleep(1000);
                    System.out.println("Reseta o log" + service.njog());
                } else {
                    vez = service.vez();


                    while (vez != log) {
                      
                        Thread.sleep(1000);
                        System.out.println("É a vez do jogador " + vez);
                        System.out.println("à espera da sua vez ...");

                        winner = service.winner();
                        vez = service.vez();

                    }
                    vez = service.vez();

                    winner = service.winner();
                    
                    while (vez == log) {

                        String tab[][] = service.vertab();
                        System.out.println("|" + tab[0][0] + "|" + tab[0][1] + "|" + tab[0][2] + "|");
                        System.out.println("|" + tab[1][0] + "|" + tab[1][1] + "|" + tab[1][2] + "|");
                        System.out.println("|" + tab[2][0] + "|" + tab[2][1] + "|" + tab[2][2] + "|");
                        System.out.println("Jogue(insira dois valores inteiros)");

                        Scanner jogada = new Scanner(System.in);

                        int c = jogada.nextInt();
                        if (c > 2 || c < 0) {
                            System.out.println("entre 0 e 2");
                        }

                        int l = jogada.nextInt();
                        if (l > 2 || l < 0) {
                            System.out.println("entre 0 e 2");
                        }

                        j = service.jogar(c, l, log);
                        if (j == -1) {
                            System.out.println("Ja alguem jogou nessa posição");
                        }

                        winner = service.winner();
                        vez = service.vez();
                    }
                }
            }
            if (winner == (-2)) {
                System.out.println("Empate");
            }
            if (winner == 0 || winner == 1) {
                System.out.println("Vencedor jogador numero:" + log);
            }


        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
