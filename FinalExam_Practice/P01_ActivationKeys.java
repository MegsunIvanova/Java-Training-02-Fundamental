package FinalExam_Practice;

import java.util.Scanner;

public class P01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //The first line of the input will be your raw activation key.
        // It will consist of letters and numbers only.
        String activationKey = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String[] instructions = input.split(">>>");
            String command = instructions[0];
            if (command.equals("Contains")) {
                //check if the raw activation key contains the given substring
                String substring = instructions[1];
                if (activationKey.contains(substring)) {
                    System.out.println(activationKey + " contains " + substring);
                } else {
                    System.out.println("Substring not found!");
                }

            } else if (command.equals("Flip")) {
                //o	Changes the substring between the given indices
                // (the end index is exclusive) to upper or lower case
                String caseType = instructions[1];
                int startIndex = Integer.parseInt(instructions[2]);
                int endIndex = Integer.parseInt(instructions[3]);
                String substring = activationKey.substring(startIndex, endIndex);
                String newSubstring = "";
                if (caseType.equals("Upper")) {
                    newSubstring = substring.toUpperCase();
                } else if (caseType.equals("Lower")) {
                    newSubstring = substring.toLowerCase();
                }
                activationKey = activationKey.replace(substring, newSubstring);
                System.out.println(activationKey);

            } else if (command.equals("Slice")) {
                //o	Deletes the characters between
                // the start and end indices (the end index is exclusive)
                int startIndex = Integer.parseInt(instructions[1]);
                int endIndex = Integer.parseInt(instructions[2]);
                String substring = activationKey.substring(startIndex, endIndex);
                activationKey = activationKey.replace(substring, "");
                System.out.println(activationKey);

            }

            input = scanner.nextLine();
        }

        System.out.println("Your activation key is: " + activationKey);
    }
}
