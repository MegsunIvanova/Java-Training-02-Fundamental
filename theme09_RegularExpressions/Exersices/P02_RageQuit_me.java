package theme09_RegularExpressions.Exersices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_RageQuit_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<text>[^0-9]+)(?<number>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<Character> uniqueChars = new ArrayList<>();
        StringBuilder message = new StringBuilder();

        while (matcher.find()) {
            String text = matcher.group("text").toUpperCase();
            int number = Integer.parseInt(matcher.group("number"));
            for (int i = 0; i < number; i++) {
                message.append(text);

            }
        }
        int count = (int) message.chars().distinct().count();
        System.out.println("Unique symbols used: " + count);
        System.out.println(message.toString());

    }
}
