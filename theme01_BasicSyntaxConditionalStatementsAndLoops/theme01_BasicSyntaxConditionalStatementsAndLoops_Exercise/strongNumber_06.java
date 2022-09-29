package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class strongNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int currentNum = number;
        int sumFactorials = 0;

        while (currentNum != 0) {
            int lastDigit = currentNum % 10;

            int currentFactorial = 1;
            for (int i = 1; i <= lastDigit; i++) {
                currentFactorial *= i;
            }
            sumFactorials += currentFactorial;

            currentNum /= 10;
        }

        if (sumFactorials == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
