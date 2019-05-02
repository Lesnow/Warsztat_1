package pl.coderslab.Zadanie_3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        System.out.println("pomyśl liczbę od 1 do 1000 a ja zgadnę ją w max 10 próbach");
        System.out.println("czy to liczba" );
    }

    private static int guess (int min, int max) {

        int guess = (max-min) / 2 + min;
        System.out.println("zgaduję: " + guess);
        return guess;
    }

    private static void asdf () {
        int min = 0;
        int max = 1000;
        int guess = 0;
        int numberOfSteps = 10;
        while(numberOfSteps > 0) {
            Scanner scan = new Scanner(System.in);

            guess = guess(min, max);
            System.out.println("Zgadłem? (odpowiedz tak lub nie)");
            String answer = getAnswer(scan);

            switch (answer) {
                case "tak" : {
                    System.out.println("Wygrałem!");
                    return;
                }
                case "nie" : {
                }
            }
            if (true) {

            }
            if(true) {
                min = guess;
            }

            if(false) {
                max = guess;
            }
        }
    }

    private static String getAnswer(Scanner scan) {
        return scan.nextLine().trim().toLowerCase();
    }
}
