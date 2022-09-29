package FinalExam_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> mirrorWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("([@#])(?<wordOne>[A-Za-z]{3,})(?:\\1){2}(?<wordTwo>[A-Za-z]{3,})(?:\\1)");
        Matcher matcher = pattern.matcher(input);
        int countWordPairs = 0;
        int validPairs = 0;

        while (matcher.find()) {
            countWordPairs++;
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            StringBuilder sb = new StringBuilder(wordTwo);
            String wordTwoReversed = sb.reverse().toString();
            if (wordOne.equals(wordTwoReversed)) {
                mirrorWords.add(wordOne + " <=> " + wordTwo);
                validPairs++;
            }
        }


        if (countWordPairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(countWordPairs + " word pairs found!");
        }

        if (validPairs > 0) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        } else {
            System.out.println("No mirror words!");
        }

    }
}
