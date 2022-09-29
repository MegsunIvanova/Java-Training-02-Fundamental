package FinalExam_Practice;

import java.util.Scanner;

public class P01_ActivationKeys_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //The first line of the input will be your raw activation key.
        // It will consist of letters and numbers only.
        String activationKey = scanner.nextLine();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Generate")) {
            //There are several types of instructions, split by ">>>"
            String[] tokens = inputLine.split(">>>");
            String command = tokens[0];
            String substring = "";
            int startIndex = 0;
            int endIndex = 0;
            switch (command) {
                case "Contains":
                    //•	"Contains>>>{substring}"
                    //check if the raw activation key contains the given substring
                    substring = tokens[1];
                    if (activationKey.contains(substring)) {
                        System.out.println(activationKey + " contains " + substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    //•	"Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}"
                    //o	Changes the substring between the given indices
                    // (the end index is exclusive) to upper or lower case
                    String upperOrLower = tokens[1];
                    startIndex = Integer.parseInt(tokens[2]);
                    endIndex = Integer.parseInt(tokens[3]);
                    substring = activationKey.substring(startIndex, endIndex);
                    if (upperOrLower.equals("Upper")) {
                        activationKey = activationKey.replace(substring, substring.toUpperCase());
                    } else if (upperOrLower.equals("Lower")) {
                        activationKey = activationKey.replace(substring, substring.toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    //•	"Slice>>>{startIndex}>>>{endIndex}"
                    //o	Deletes the characters between
                    // the start and end indices (the end index is exclusive)
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    substring = activationKey.substring(startIndex, endIndex);
                    activationKey = activationKey.replace(substring, "");
                    System.out.println(activationKey);
                    break;
            }
            inputLine = scanner.nextLine();
        }

        System.out.println("Your activation key is: " + activationKey);
    }
}
