package theme08_TextProcessing.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P08_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringsArr = scanner.nextLine().split("\\s+");
        double result = 0.0;

        for (String text : stringsArr) {
            char firstLetter = text.charAt(0);
            char lastLetter = text.charAt(text.length() - 1);
            int number = Integer.parseInt(text.substring(1, text.length() - 1));
            int firstLetterPosition = Character.toUpperCase(firstLetter) - 64;
            int lastLetterPosition = Character.toUpperCase(lastLetter) - 64;
            double currentResult = 0;
            if (Character.isUpperCase(firstLetter)) {
                currentResult = number*1.0 / firstLetterPosition;
            } else {
                currentResult = number*1.0 * firstLetterPosition;
            }
            if (Character.isUpperCase(lastLetter)) {
                currentResult -= lastLetterPosition;
            } else {
                currentResult += lastLetterPosition;
            }
            result += currentResult;
        }

        System.out.printf("%.2f", result);
    }

}
