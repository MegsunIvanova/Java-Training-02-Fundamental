package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class fromLeftToTheRight_02me_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            String input = scanner.nextLine();

            String left = "";
            String right = "";
            boolean isRight = false;

            for (int j = 0; j < input.length(); j++) {
                char symbol = input.charAt(j);
                if (symbol == ' ') {
                    isRight = true;
                    continue;
                }
                if (isRight) {
                    right = String.format("%s%c", right, symbol);
                } else {
                    left = String.format("%s%c", left, symbol);
                }
            }

            long leftNum = Long.parseLong(left);
            long rightNum = Long.parseLong(right);

            long maxNum = Math.abs(leftNum);
            if (rightNum > leftNum) {
                maxNum = Math.abs(rightNum);
            }

            int sumDigits = 0;

            while (maxNum != 0) {
                int digit = (int) (maxNum % 10);
                sumDigits += digit;

                maxNum /= 10;
            }
            System.out.println(sumDigits);
        }
    }
}
