package theme02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class lowerOrUpper_08_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letter = scanner.nextLine().charAt(0);


        if (Character.isUpperCase(letter)) {
            System.out.println("upper-case");
        } else if (Character.isLowerCase(letter)) {
            System.out.println("lower-case");
        }
    }
}
