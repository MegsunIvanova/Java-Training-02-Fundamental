package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class refactoringPrimeChecker_04me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lastNum = Integer.parseInt(scanner.nextLine());
        for (int currentNum = 2; currentNum <= lastNum; currentNum++) {
            boolean isPrime = true;
            for (int divider = 2; divider < currentNum; divider++) {
                if (currentNum % divider == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", currentNum, isPrime);
        }

    }
}
