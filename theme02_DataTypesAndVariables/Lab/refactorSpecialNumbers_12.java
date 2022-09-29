package theme02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class refactorSpecialNumbers_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean isSpecial = false;

        for (int i = 1; i <= number; i++) {
            int currentNum = i;
            int sum = 0;
            while (currentNum > 0) {
                sum += currentNum % 10;
                currentNum = currentNum / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            String result = String.format("%b",isSpecial);

            result= Character.toUpperCase(result.charAt(0))+result.substring(1);

            System.out.printf("%d -> %s%n", i, result);

        }

    }
}
