package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P08_LettersChangeNumbers_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] codes = scanner.nextLine().split("\\s+");
        double totalSum = 0.0;

        for (String code : codes) {
            double number = getModifiedNumber(code);
            totalSum += number;
        }

        System.out.printf("%.2f", totalSum);
    }

    private static double getModifiedNumber(String code) {
        char firstLetter = code.charAt(0);
        char secondLetter = code.charAt(code.length() - 1);
        double number = Double.parseDouble(code
                .replace(firstLetter, ' ')
                .replace(secondLetter, ' ')
                .trim());

        if (Character.isUpperCase(firstLetter)) {
            int positionUpperCase = (int) firstLetter - 64;
            number /= positionUpperCase;
        } else {
            int positionLowerCase = (int) firstLetter - 96;
            number *= positionLowerCase;
        }

        if (Character.isUpperCase(secondLetter)) {
            int positionUpperCase = (int) secondLetter - 64;
            number -= positionUpperCase;
        } else {
            int positionLowerCase = (int) secondLetter - 96;
            number += positionLowerCase;
        }
        return number;
    }
}
