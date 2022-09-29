package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String string1 = input.split(" ")[0];
        String string2 = input.split(" ")[1];

        int maxLen = Math.max(string1.length(), string2.length());
        int result = 0;

        for (int i = 0; i < maxLen; i++) {
            char char1 = 1;
            if (i < string1.length()) {
                char1 = string1.charAt(i);
            }
            char char2 = 1;
            if (i < string2.length()) {
                char2 = string2.charAt(i);
            }
            result += char1 * char2;
        }

        System.out.println(result);
    }
}
