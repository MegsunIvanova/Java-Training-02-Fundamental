package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class sumOfChars_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sumChars = 0;

        for (int i = 1; i <= number; i++) {
            char symbol = scanner.nextLine().charAt(0);
            int asciiCode = (int) symbol;
            sumChars += asciiCode;

        }
        System.out.println("The sum equals: " + sumChars);
    }
}
