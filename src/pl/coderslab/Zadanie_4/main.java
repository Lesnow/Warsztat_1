package pl.coderslab.Zadanie_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("wpisz kod rzutu!");
        while (!scan.hasNextLine());
        String code = scan.nextLine();
        System.out.println("wynik to: " + Dice(code));
    }

    private static int Dice (String code) {
        int sum = 0;
        int bonus = 0;
        int numberOfThrows = 0;
        int diceDimention = 0;

        String tempCode = code.trim().toLowerCase();
        if (!tempCode.contains("d")) {
            System.out.println("błędnie wpisany kod");
            return 0;
        }
        int dIndex = tempCode.indexOf("d");
        try {
            if (dIndex == 0) {
                numberOfThrows = 1;
            }
            else {
                String numberOfThrowsString = tempCode.substring(0, dIndex).trim();
                numberOfThrows = Integer.parseInt(numberOfThrowsString);
            }

            String bonusType = new String();
            if (tempCode.contains("+")) {
                bonusType = "+";
            }
            else if (tempCode.contains("-")) {
                bonusType = "-";
            }
            else {
                bonusType = null;
            }

            int bonusSignIndex = 0;
            if (bonusType != null) {
                bonusSignIndex = tempCode.indexOf(bonusType);
                bonus = getBonus(tempCode, bonusSignIndex);
            }

            diceDimention = getDiceDimention(tempCode,dIndex + 1, bonusSignIndex);
            if (diceDimention == 0 ) {
                return 0;
            }
            sum = diceThrow(numberOfThrows, diceDimention);
            if (bonus > 0 && bonusType.equals("+")) {
                System.out.println("premia: +" + bonus);
            }
            else if (bonus > 0 && bonusType.equals("-")) {
                System.out.println("premia: -" + bonus);
            }
            sum += bonus;
        }
        catch (NumberFormatException e) {
            System.out.println("błędnie wpisany kod");
            return 0;
        }
        return sum;
    }

    private static int diceThrow (int numberOfThrows, int diceDimentions) {
        Random rand = new Random();
        int sum = 0;
        for (int i = 0; i < numberOfThrows; i++) {
            int oneThrow = rand.nextInt(diceDimentions) + 1;
            System.out.println("rzut " + (i+1) + " = " + oneThrow);
            sum += oneThrow;
        }
        return sum;
    }

    private static int getBonus(String codeString, int signIndex) {
        String tempZString = codeString.substring(signIndex + 1).trim();
        return Integer.parseInt(tempZString);
    }

    private static int getDiceDimention(String codeString, int DiceDimentionPositionIndex, int signPositionIndex) {
        if (signPositionIndex == 0) {
            signPositionIndex = codeString.length();
        }
        String tempString = codeString.substring(DiceDimentionPositionIndex, signPositionIndex).trim();
        int diceDimention = Integer.parseInt(tempString);
        Integer[] validDimentions = {3, 4, 6, 8, 10, 12, 20, 100};
        if (Arrays.asList(validDimentions).contains(diceDimention)) {
            return diceDimention;
        }
        System.out.println("taki rozdzaj kostki nie występuje");
        System.out.println("Dostępne typy kostek występujące w grach to:\n" +
                "D3, D4, D6, D8, D10, D12, D20, D100.");
        return 0;
    }
}
