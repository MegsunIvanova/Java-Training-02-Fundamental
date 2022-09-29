package FinalExam_Practice;

import java.util.Scanner;

public class P01_PasswordReset_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Done")) {
            if (inputLine.contains("TakeOdd")) {
                //•	"TakeOdd"
                //Takes only the characters at odd indices and
                // concatenates them to obtain the new raw password and then prints it.
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < text.length(); i += 2) {
                    sb.append(text.charAt(i));
                }
                text = sb.toString();
                System.out.println(text);
            } else if (inputLine.contains("Cut")) {
                //•	"Cut {index} {length}"
                int index = Integer.parseInt(inputLine.split(" ")[1]);
                int length = Integer.parseInt(inputLine.split(" ")[2]);
                //o	Gets the substring with the given length
                // starting from the given index from the password
                //and removes its first occurrence,
                // then prints the password on the console
                String textBeforeSubstring = text.substring(0, index);
                String textAfterSubstring = text.substring(index + length);
                text = textBeforeSubstring + textAfterSubstring;
                System.out.println(text);
            } else if (inputLine.contains("Substitute")) {
                //•	"Substitute {substring} {substitute}"
                String substring = inputLine.split(" ")[1];
                String substitute = inputLine.split(" ")[2];
                if (text.contains(substring)) {
                    text = text.replace(substring, substitute);
                    System.out.println(text);
                } else {
                    System.out.println("Nothing to replace!");
                }

            }

            inputLine = scanner.nextLine();
        }

        System.out.println("Your password is: " + text);


    }
}
