package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class decryptingMessage_05me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int numberOfCharacters = Integer.parseInt(scanner.nextLine());
        String message = "";

        for (int i = 1; i <= numberOfCharacters; i++) {
            char letter = scanner.nextLine().charAt(0);
            letter += key;
            message = String.format("%s%c", message, letter);
        }
        System.out.println(message);
    }
}
