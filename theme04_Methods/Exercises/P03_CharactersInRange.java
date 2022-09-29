package theme04_Methods.Exercises;

import java.util.Scanner;

public class P03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        printCharactersInRange(firstChar, secondChar);

    }

    private static void printCharactersInRange(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            char tempChar = firstChar;
            firstChar = secondChar;
            secondChar = tempChar;
        }
        for (int i = (int) firstChar + 1; i < secondChar; i++) {
            System.out.printf("%c ", i);

        }
    }

}
