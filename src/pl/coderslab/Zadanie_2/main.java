package pl.coderslab.Zadanie_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class main {
    private static final int MAX_NR_OF_TRIES = 3;

    public static void main(String[] args) {

        int tryCounter = 0;
        Scanner scan = new Scanner (System.in);

        System.out.println("GRA LOTTO \npodaj 6 liczb które typujesz");

        Integer[] userTypes = new Integer [6];
        for (int i = 0; i < userTypes.length; i++) {
            while (true) {
                if (tryCounter > MAX_NR_OF_TRIES) {
                    System.out.println("zbyd dużo błędnych prób");
                    return;
                }

                System.out.print("liczba numer " + (i+1) +" : ");
                userTypes[i] = getNumberFromUser(scan);
                if (userTypes[i] == 0) {
                    System.out.println("zbyd dużo błędnych prób");
                    return;
                }

                boolean isTheSameFlag = false;
                for(int j = 0; j < i; j++) {
                        if (userTypes[i] == userTypes[j]) {
                            System.out.println("ta liczba została już podana");
                            isTheSameFlag = true;
                            tryCounter++;
                        }
                }
                if (!isTheSameFlag) {
                    break;
                }

            }
        }

        Integer[] arr = new Integer[49];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int points = 0;
        Collections.shuffle(Arrays.asList(arr));

        for (int i = 0; i < userTypes.length; i++) {
            if (Arrays.asList(userTypes).contains(arr[i])){
                points++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("liczba punktów to: " + points);
        switch (points) {
            case 3: {
                System.out.println("gratulacje trafiłeś 3");
            }
            case 4: {
                System.out.println("gratulacje trafiłeś 4");
            }
            case 5: {
                System.out.println("gratulacje trafiłeś 5");
            }
            case 6: {
                System.out.println("gratulacje trafiłeś 6, wygrałeś złote kalesony!!");
            }
            default: {
                System.out.println("nic nie wygrałeś");
            }
        }

    }


    private static int getNumberFromUser(Scanner scan) {
        int tryCounter = 0;
        while (true) {
            while(!scan.hasNextInt()) {
                scan.next();
                scan.nextLine();
                System.out.println("to nie jest liczba");
                tryCounter++;
                if (tryCounter > MAX_NR_OF_TRIES) {
                    return 0;
                }
                System.out.println("Podaj poprawną liczbę!");
            }

            int userNumber = scan.nextInt();
            if (userNumber > 49 || userNumber < 1) {
                System.out.println("wybrana liczba jest poza zakresem losowanych liczb");
                tryCounter++;
                if (tryCounter > MAX_NR_OF_TRIES) {
                    return 0;
                }
                System.out.println("podaj liczbę w zakresie od 1 do 49");
                continue;
            }
            return userNumber;
        }
    }
}