package pl.coderslab.Zadanie_1;

import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Random randGenerator = new Random();
        int randNumber = randGenerator.nextInt(99) + 1;

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Zgadnij liczbę");

            if (!scan.hasNextInt()) {
                scan.nextLine();
                System.out.println("To nie jest liczba");
                continue;
            }
            int userShot = scan.nextInt();

            if (userShot == randNumber) {
                System.out.println("Wygrałeś!!");
                return;
            }
            else if (userShot > randNumber) {
                System.out.println("za dużo");
            }
            else {
                System.out.println("za mało");
            }
        }
    }
}