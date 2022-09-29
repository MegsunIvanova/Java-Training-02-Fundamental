package theme09_RegularExpressions.Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	A valid full name has the following characteristics:
        //o	It consists of two words.
        //o	Each word starts with a capital letter.
        //o	After the first letter, it only contains lowercase letters afterward.
        //o	Each of the two words should be at least two letters long.
        //o	The two words are separated by a single space.
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String name = matcher.group();
            System.out.print(name + " ");
        }
    }
}
