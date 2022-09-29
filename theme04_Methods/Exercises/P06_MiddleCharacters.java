package theme04_Methods.Exercises;

import java.util.Scanner;

public class P06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //method that prints the middle character.
        // If the length of the string is even, there are two middle characters.
        printMiddleCharacters(input);
    }

    private static void printMiddleCharacters(String text) {

        if (text.length() % 2 != 0) {
            int indexMiddleChar = text.length() / 2;
            System.out.println(text.charAt(indexMiddleChar));

        } else {
            int indexFirstMiddleChar = text.length() / 2 - 1;
            int indexSecondMiddleChar = text.length() / 2;
            System.out.println("" + text.charAt(indexFirstMiddleChar) +
                    text.charAt(indexSecondMiddleChar));
        }

    }

}
