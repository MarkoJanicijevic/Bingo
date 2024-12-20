package Bingo;
import java.util.Random;
import java.util.Scanner;


public class Bingo {
    public static void main(String[] args) {
        int [] x = generisi();
        bingo(unesiBrojeve(), x);
        stampac(x);
    }
    public static int[] unesiBrojeve () {
        Scanner sc = new Scanner(System.in);
        int [] niz_brojeva = new int[6];
        for (int i = 0; i < niz_brojeva.length; i++) {
            System.out.println("Unesite sledeci broj: ");
            niz_brojeva[i] = sc.nextInt();
        }
        return niz_brojeva;
    }

    public static int[] generisi() {
        int [] svi_brojevi = new int[48];
        for (int i = 0; i < svi_brojevi.length; i++) {
            svi_brojevi[i] = i + 1;
        }
        Random rn = new Random();
        int [] generisani_brojevi = new int[30];
        for (int i = 0; i < generisani_brojevi.length; i++) {
            int j = rn.nextInt(svi_brojevi.length - 1);
            if (svi_brojevi[j] > 0) {
                generisani_brojevi[i] = svi_brojevi[j];
            }
        }

        return generisani_brojevi;
    }

    public static void stampac(int[] x) {
        String niz = "Bingo brojevi su: ";

        for (int i = 0; i < x.length; i++) {
            String clan = String.valueOf(x[i]);
            niz = niz + clan + ", ";
        }
        System.out.println(niz);
    }



    public static void bingo (int[] x, int [] y) {
        int brojac = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (x[i] == y[j]) {
                    brojac++;
                }
            }
        }
        if (brojac >= 6) {
            System.out.println("BINGO!");
        } else {
            System.out.println("Niste dobili BINGO. Probajte ponovo.");
        }
    }
}