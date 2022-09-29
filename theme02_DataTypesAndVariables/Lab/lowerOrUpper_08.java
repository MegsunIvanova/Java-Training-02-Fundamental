package theme02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class lowerOrUpper_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letter = scanner.nextLine().charAt(0);

        if (letter >= 'a' && letter <= 'z') {
            System.out.println("upper-case");
        } else if (letter >= 'A' && letter <= 'Z') {
            System.out.println("lower-case");
        }
    }
}
