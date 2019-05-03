package pl.coderslab.Zadanie_3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        System.out.println("pomyśl liczbę od 1 do 1000 a ja zgadnę ją w max 10 próbach");

        asdf();
    }

    private static void asdf () {
        int min = 0;
        int max = 1000;
        int guess = 0;
        int numberOfSteps = 1;
        int tryCnt = 0;

        Scanner scan = new Scanner(System.in);
        while (numberOfSteps < 11) {

            guess = (max-min) / 2 + min;

            System.out.println("to jest próba nr. " + numberOfSteps);
            System.out.println("Zgaduję: " + guess);
            System.out.println("Zgadłem? (odpowiedz tak lub nie)");

            String answer = scan.nextLine().trim().toLowerCase();
            if (answer.equals("tak")) {
                System.out.println("Wygrałem!");
                return;
            }
            else if (answer.equals("nie")) {

            }
            else {
                System.out.println("Podpowiedź nie pasuje do wzoru.");
                System.out.println("Wpisz odpowiedz \"tak\" lub \"nie\"");
                System.out.println("zgaduje jeszcze raz");

                tryCnt++;
                if (tryCnt == 10) {
                    System.out.println("podano podpowiedź niepasującą do wzoru zbyt wiele razy!!\nKoniec");
                    return;
                }
                continue;
            }

            System.out.println("za dużo?");
            answer = scan.nextLine().trim().toLowerCase();
            if (answer.equals("tak")) {
                if (guess == 1) {
                    System.out.println("oszukujesz!");
                    System.out.println("koniec");
                    return;
                }
                max = guess;
                numberOfSteps++;
                continue;
            }
            else if (answer.equals("nie")) {
            }

            else {
                System.out.println("Odpowiedź nie pasuje do wzoru.\nWpisz odpowiedz \"tak\" lub \"nie\"");
                tryCnt++;
                if (tryCnt == 10) {
                    System.out.println("podano odpowiedź niepasującą do wzoru zbyt wiele razy!!\nKoniec");
                    return;
                }
                continue;
            }

            System.out.println("za mało?");
            answer = scan.nextLine().trim().toLowerCase();
            if (answer.equals("tak")) {
                min = guess;
                numberOfSteps++;
                continue;
            } else if (answer.equals("nie")) {
                System.out.println("nie oszukuj");
                continue;
            } else {
                System.out.println("Odpowiedź nie pasuje do wzoru.\nWpisz odpowiedz \"tak\" lub \"nie\"");
                tryCnt++;
                if (tryCnt == 10) {
                    System.out.println("podano odpowiedź niepasującą do wzoru zbyt wiele razy!!\nKoniec");
                    return;
                }
                continue;
            }

        }
        System.out.println("dziwne... nie udało mi się zgadnąć liczby");
    }
}
