package theme09_RegularExpressions.Exersices;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //Emails are considered to be in format <user>@<host>
        //•	<user> is a sequence of letters and digits,
        // where '.', '-' and '_' can appear between them
        //•	<host> is a sequence of at least two words, separated by dots '.'.
        // Each word is a sequence of letters and can have hyphens '-'
        // between the letters
        String regex = "[A-Za-z0-9]+[._-]?[A-Za-z0-9]+@[A-Za-z]+-?[A-Za-z]+(\\.[A-Za-z]+-?[A-Za-z]+)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
