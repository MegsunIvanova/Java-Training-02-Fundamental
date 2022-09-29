package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class messages_05me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfInputs; i++) {
            String input = scanner.nextLine();
            char currentChar = 0;

            if (input.equals("0")) {
                currentChar = 32;
            } else {

                int numberOfDigits = input.length();
                int mainDigit = Integer.parseInt(input) % 10;
                if (mainDigit < 8) {
                    currentChar = (char) (97 + (mainDigit - 2) * 3 + (numberOfDigits - 1));
                } else {
                    currentChar = (char) (97 + (mainDigit - 2) * 3 + (numberOfDigits - 1) + 1);
                }
            }
            System.out.print("" + currentChar);
        }


    }
}
