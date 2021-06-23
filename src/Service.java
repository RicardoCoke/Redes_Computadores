
import java.util.Scanner;
import java.rmi.RemoteException;

public class Service implements ServiceInterface {

    String tab[][] = new String[3][3];
    static int vez;

    @Override
    public void fill() throws RemoteException {
        String s = "_";
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                tab[l][c] = s;
            }
        }
    }

    @Override
    public String sayHello() throws RemoteException {
        System.out.println("No servidor ....");
        return "hello";
    }
    static int nj=0;

    @Override
    public int login() throws RemoteException {

        if (nj > 4) {
            nj=0;
            return 0;
        }
        return nj++;
    }
    int a;
    int b;
    static int c;

    @Override
    public int jogar(int C1, int C2, int nj) throws RemoteException {

        if (nj == 0) {
            if (tab[C1][C2] != "_") {
                return -1;
            }
            tab[C1][C2] = "O";
            vez = 1;
            c++;

        }
        if (nj == 1) {
            if (tab[C1][C2] != "_") {
                return -1;
            }
            tab[C1][C2] = "X";
            vez = 0;
            c++;

        }

        if (nj == 2) {
            if (tab[C1][C2] != "_") {
                return -1;
            }
            tab[C1][C2] = "O";
            vez = 1;
            c++;

        }
        if (nj == 3) {
            if (tab[C1][C2] != "_") {
                return -1;
            }
            tab[C1][C2] = "X";
            vez = 0;
            c++;

        }
        return 1;
    }

    @Override
    public int vez() throws RemoteException {
        int a = 0;
        int b = a+1;
        if (vez == a) {
            a = a | 1;
            return a;
        }
        if (vez == nj) {
            return b;
        }
        return -1;
    }

    @Override
    public String[][] vertab() throws RemoteException {
        return tab;
    }

    @Override
    public int winner() throws RemoteException {
        int contador;
        for (int l = 0; l < 3; l++) {
            contador = 0;
            for (int c = 0; c < 3; c++) {
                if (tab[l][c].equals("O")) {
                    contador++;
                }
                if (contador == 3) {
                    return 0;
                }
            }
        }
        for (int c = 0; c < 3; c++) {
            contador = 0;
            for (int l = 0; l < 3; l++) {
                if (tab[l][c].equals("O")) {
                    contador++;
                }
                if (contador == 3) {
                    return 0;
                }
            }
        }

        for (int l = 0; l < 3; l++) {
            contador = 0;
            for (int c = 0; c < 3; c++) {
                if (tab[l][c].equals("X")) {
                    contador++;
                }
                if (contador == 3) {
                    return 1;
                }
            }
        }
        for (int c = 0; c < 3; c++) {
            contador = 0;
            for (int l = 0; l < 3; l++) {
                if (tab[l][c].equals("X")) {
                    contador++;
                }
                if (contador == 3) {
                    return 1;
                }
            }
        }
        if (tab[0][0].equals("O") && tab[1][1].equals("O") && tab[2][2].equals("O")) {
            return 0;
        }

        if (tab[0][2].equals("O") && tab[1][1].equals("O") && tab[2][0].equals("O")) {
            return 0;
        }

        if (tab[0][0].equals("X") && tab[1][1].equals("X") && tab[2][2].equals("X")) {
            return 1;
        }

        if (tab[0][2].equals("X") && tab[1][1].equals("X") && tab[2][0].equals("X")) {
            return 1;
        }

        //empate
        contador = 0;
        for (int c = 0; c < 3; c++) {
            for (int l = 0; l < 3; l++) {
                if (tab[l][c].equals("X") || tab[l][c].equals("O")) {
                    contador++;
                }
                if (contador == 9) {
                    return -2;
                }
            }
        }
        return -1;
    }

    @Override
    public int njog() throws RemoteException {
        return c;
    }
}
