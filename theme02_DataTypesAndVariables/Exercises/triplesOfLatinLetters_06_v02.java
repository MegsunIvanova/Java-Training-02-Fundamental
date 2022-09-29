package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class triplesOfLatinLetters_06_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (char letter1 = 'a'; letter1 < 'a' + number; letter1++) {
            for (char letter2 = 'a'; letter2 < 'a' + number; letter2++) {
                for (char letter3 = 'a'; letter3 < 'a' + number; letter3++) {
                    System.out.printf("%c%c%c%n", letter1, letter2, letter3);
                }

            }

        }
    }
}
