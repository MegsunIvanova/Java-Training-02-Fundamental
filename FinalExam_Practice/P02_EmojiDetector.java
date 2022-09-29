package FinalExam_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //1) get the cool threshold (by multiplying all the digits found in the input)
        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(input);
        long coolThreshold = 1;
        while (digitMatcher.find()) {
            int digit = Integer.parseInt(digitMatcher.group());
            coolThreshold *= digit;
        }
        System.out.println("Cool threshold: " + coolThreshold);

        //2) extract emojis from the input
        //emoji is valid when:
        //•	It is surrounded by 2 characters, either "::" or "**"
        //•	It is at least 3 characters long
        //•	It starts with a capital letter
        //•	Continues with lowercase letters only
        Pattern emojiPattern = Pattern.compile("((:{2})|(\\*{2}))(?<emoji>[A-Z][a-z]{2,})(?:\\1)");
        Matcher emojiMatcher = emojiPattern.matcher(input);
        int emojiCounter = 0;
        List<String> coolEmoji = new ArrayList<>();
        while (emojiMatcher.find()) {
            emojiCounter++;
            String emoji = emojiMatcher.group("emoji");
            if (isEmojiCool(emoji, coolThreshold)) {
                coolEmoji.add(emojiMatcher.group());
            }
        }
        System.out.println(emojiCounter + " emojis found in the text. The cool ones are:");
        System.out.println(String.join("\n", coolEmoji));
    }

    private static boolean isEmojiCool(String emoji, long coolThreshold) {
        int emojiCoolLevel = 0;
        for (char symbol : emoji.toCharArray()) {
            emojiCoolLevel += symbol;
        }
        return emojiCoolLevel > coolThreshold;
    }
}
