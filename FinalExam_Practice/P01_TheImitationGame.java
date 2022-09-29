package FinalExam_Practice;

import java.util.Scanner;

public class P01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String instruction = input.split("\\|")[0];
            switch (instruction) {
                case "Move":
                    //o	Moves the first n letters to the back of the string
                    int num = Integer.parseInt(input.split("\\|")[1]);
                    message = message.substring(num) + message.substring(0, num);
                    break;
                case "Insert":
                    //o	Inserts the given value before the given index in the string
                    int index = Integer.parseInt(input.split("\\|")[1]);
                    String value = input.split("\\|")[2];
                    message = message.substring(0, index) + value + message.substring(index);
                    break;
                case "ChangeAll":
                    String substring = input.split("\\|")[1];
                    String replacement = input.split("\\|")[2];
                    message = message.replace(substring, replacement);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
