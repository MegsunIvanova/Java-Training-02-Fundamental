package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPasswords = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("([^>]+)>(?<password>[0-9]{3}\\|[a-z]{3}\\|[A-Z]{3}\\|[^<>]{3})<\\1");
        for (int i = 0; i < numberOfPasswords; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                String encryptedPassword = matcher.group("password");
                encryptedPassword = encryptedPassword.replaceAll("\\|", "");
                System.out.println("Password: " + encryptedPassword);
            } else {
                System.out.println("Try another password!");
            }
        }

    }
}
