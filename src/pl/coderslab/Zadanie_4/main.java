package pl.coderslab.Zadanie_4;

import java.util.Scanner;

/*
Kostka do gry
Napisz funkcję, która:
1. przyjmie w parametrze taki kod w postaci String,
2. rozpozna wszystkie dane wejściowe: rodzaj kostki, liczbę rzutów, modyfikator,
3. wykona symulację rzutów i zwróci wynik.
Typy kostek występujące w grach: D3, D4, D6, D8, D10, D12, D20, D100.

xDy+z
y – rodzaj kostek, których należy użyć (np. D6, D10),
x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),
z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("wpisz kod rzutu!");
        while (!scan.hasNextLine());
        String code = scan.nextLine();


        System.out.println(Dice(code));
    }

    private static int Dice (String code) {
        int sum = 0;
        int x = 1;
        int y = 1;
        int z = 0;

        String tempCode = code.trim().toLowerCase();
        System.out.println(tempCode);
        if (!tempCode.contains("d")) {
            System.out.println("dupa");
            return 0;
        }
        int dIndex = tempCode.indexOf("d");
        if (dIndex == 0) {
            x = 1;
        }
        else {
            System.out.println(tempCode.substring(0, dIndex));
            x = Integer.parseInt(tempCode.substring(0, dIndex));
        }


        /*

        DODAC RANDOM!!!!


         */
        if (tempCode.contains("+")) {
            int plusIndex = tempCode.indexOf("+");
            System.out.println(tempCode.substring(dIndex + 1, plusIndex));
            y = Integer.parseInt(tempCode.substring(dIndex + 1, plusIndex));
            z = Integer.parseInt(tempCode.substring(plusIndex + 1));
        }
        else {
            y = Integer.parseInt(tempCode.substring(dIndex + 1));
        }

        return x*y + z;
    }

}
