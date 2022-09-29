package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class sumDigits_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int currentNum = number;
        int sumDigits = 0;

        while (currentNum > 0) {
            sumDigits += currentNum % 10;

            currentNum /= 10;
        }

        System.out.println(sumDigits);
    }
}
