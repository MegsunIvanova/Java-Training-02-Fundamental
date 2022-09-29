package theme04_Methods.Exercises;

import java.util.Scanner;

public class P09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            System.out.println(isPalindrome(input));
            input = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String number) {
        String backwardNumber = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            backwardNumber = "" + backwardNumber + number.charAt(i);
        }
        return number.equals(backwardNumber);
    }
}
