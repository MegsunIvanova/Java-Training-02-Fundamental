package theme04_Methods.Lab;

import java.util.Scanner;

public class P10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(getMultipleOfEvensAndOdds(number));

    }

    public static int getMultipleOfEvensAndOdds(int number) {
        int evenSum = getSumOfEvenDigits(number);
        int oddSum = getSumOfOddDigits(number);
        return evenSum * oddSum;
    }

    public static int getSumOfEvenDigits(int number) {
        int sumOfEvenDigits = 0;
        int currentNum = number;
        while (currentNum != 0) {
            int digit = currentNum % 10;
            if (digit % 2 == 0) {
                sumOfEvenDigits += digit;
            }

            currentNum /= 10;
        }
        return sumOfEvenDigits;
    }

    public static int getSumOfOddDigits(int number) {
        int sumOfOddDigits = 0;
        int currentNum = number;
        while (currentNum != 0) {
            int digit = currentNum % 10;
            if (digit % 2 != 0) {
                sumOfOddDigits += digit;
            }

            currentNum /= 10;
        }
        return sumOfOddDigits;
    }
}
