package FinalExam_Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EmojiDetector_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        //намиране на coolThreshold -> произведението на всички цифри от input
        long coolThreshold = 1;
        Pattern digitsPattern = Pattern.compile("[0-9]");
        Matcher digitsMatcher = digitsPattern.matcher(input);
        while (digitsMatcher.find()) {
            coolThreshold *= Integer.parseInt(digitsMatcher.group());
        }
        System.out.println("Cool threshold: " + coolThreshold);

        //намиране на валидните emoji
        Pattern emojiPattern = Pattern.compile("(::|\\*\\*)(?<letters>[A-Z][a-z]{2,})\\1");
        Matcher emojiMatcher = emojiPattern.matcher(input);
        List<String> validEmojiList = new ArrayList<>();
        List<String> coolEmojiList = new ArrayList<>();
        while (emojiMatcher.find()) {
            String emoji = emojiMatcher.group();
            validEmojiList.add(emoji);
            //изчисляване на coolLevel за текущото emoji
            String letters = emojiMatcher.group("letters");
            long coolLevel = getCoolLevel(letters);
            if (coolLevel > coolThreshold) {
                coolEmojiList.add(emoji);
            }
        }

        System.out.println(validEmojiList.size() + " emojis found in the text. The cool ones are:");
        System.out.println(String.join("\n", coolEmojiList));

    }

    private static long getCoolLevel(String letters) {
        long coolLevel = 0;
        for (char symbol : letters.toCharArray()) {
            coolLevel += symbol;
        }
        return coolLevel;
    }
}
