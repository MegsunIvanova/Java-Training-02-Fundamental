package theme09_RegularExpressions.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\+359([ -])2(?:\\1)\\d{3}(?:\\1)\\d{4}\\b");
        Matcher matcher = pattern.matcher(input);
        List<String> phoneNumbers = new ArrayList<>();

        while (matcher.find()) {
            String phoneNumber = matcher.group();
            phoneNumbers.add(phoneNumber);
        }

        System.out.println(String.join(", ", phoneNumbers));

    }
}
