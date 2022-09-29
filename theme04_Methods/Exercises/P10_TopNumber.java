package theme04_Methods.Exercises;

import java.util.Scanner;

public class P10_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //. Find all top numbers in the range [1 … n] and print them.
        // A top number holds the following properties:
        //•	Its sum of digits is divisible by 8, e.g. 8, 17, 88.
        //•	Holds at least one odd digit, e.g. 232, 707, 87578.

        for (int i = 1; i <= n; i++) {
            if (isItsSumOfDigitsDivisibleBy8(i) && isHoldsOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isItsSumOfDigitsDivisibleBy8(int n) {
        //намиране на сумата от цифрите
        int currentNum = n;
        int sumOfDigits = 0;
        while (currentNum != 0) {
            sumOfDigits += currentNum % 10;
            currentNum /= 10;
        }

        //проверка дали сумата от цифрите се дели на 8
        if (sumOfDigits % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isHoldsOddDigit(int n) {
        //проверяваме всяка една от цифрите в числото дали е нечетна
        int currentNum = n;
        while (currentNum != 0) {
            if (currentNum % 2 != 0) {
                return true;
            }
            currentNum /= 10;
        }
        return false;
    }
}
