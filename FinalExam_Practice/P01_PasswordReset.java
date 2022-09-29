package FinalExam_Practice;

import java.util.Scanner;

public class P01_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            if (command.equals("TakeOdd")) {
                //Takes only the characters at odd indices
                // and concatenates them to obtain the new raw password and then prints it.
                StringBuilder newPassword = new StringBuilder();
                for (int i = 1; i < password.length(); i += 2) {
                    newPassword.append(password.charAt(i));
                }
                password = newPassword.toString();
                System.out.println(password);

            } else if (command.equals("Cut")) {
                int index = Integer.parseInt(tokens[1]);
                int length = Integer.parseInt(tokens[2]);
                //o	Gets the substring with the given length starting from the given index
                // from the password and removes its first occurrence,
                // then prints the password on the console
//                String substring = password.substring(0, index);
                String substring1 = password.substring(0, index);
                String substring2 = password.substring(index + length);
                password = substring1 + substring2;
                System.out.println(password);

            } else if (command.equals("Substitute")) {
                String substring = tokens[1];
                String substitute = tokens[2];
                //o	If the raw password contains the given substring,
                // replaces all of its occurrences with the substitute text given
                if (password.contains(substring)) {
                    password = password.replace(substring, substitute);
                    System.out.println(password);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
