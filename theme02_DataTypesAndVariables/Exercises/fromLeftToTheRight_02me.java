package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class fromLeftToTheRight_02me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= number; i++) {
            String input = scanner.nextLine();
            int indexSecondNum = 0;
            for (int j = 0; j < input.length(); j++) {
                char symbol = input.charAt(j);
                if (symbol == ' ') {
                    indexSecondNum = j+1;
                    break;
                }
            }
            int indexLastDig = input.length() - 1;
            long leftNum = Long.parseLong(input.substring(0, indexSecondNum - 1));
            long rightNum = Long.parseLong(input.substring(indexSecondNum, indexLastDig + 1));

            long sumNum = Math.max(leftNum,rightNum);

            int sumDigits = 0;
            while (sumNum > 0) {
                int digit = (int) (sumNum % 10);
                sumDigits += digit;
                sumNum /= 10;
            }
            System.out.println(sumDigits);
        }
    }
}
