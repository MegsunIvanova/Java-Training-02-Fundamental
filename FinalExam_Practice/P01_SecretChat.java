package FinalExam_Practice;

import java.util.Scanner;

public class P01_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //concealed message:
        String message = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Reveal")) {
            String[] tokens = command.split(":\\|:");

            if ("InsertSpace".equals(tokens[0])) {
                int index = Integer.parseInt(tokens[1]);
                //Inserts a single space at the given index.
                // The given index will always be valid.
                message = message.substring(0, index) + " " + message.substring(index);
                System.out.println(message);

            } else if ("Reverse".equals(tokens[0])) {
                String substring = tokens[1];
                if (message.contains(substring)) {
                    String reversedText = (new StringBuilder(substring)).reverse().toString();
                    message = message.replaceFirst(substring, "");
                    message = message + reversedText;
                    System.out.println(message);
                } else {
                    System.out.println("error");
                }
            } else if ("ChangeAll".equals(tokens[0])) {
                String text = tokens[1];
                String replacement = tokens[2];
                //	Changes all occurrences of the given substring with the replacement text
                message = message.replace(text, replacement);
                System.out.println(message);
            }
            command = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}
