package theme09_RegularExpressions.Exersices;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03_PostOffice_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"{firstPart}|{secondPart}|{thirdPart}"
        String[] input = scanner.nextLine().split("\\|");
        String firstPart = input[0];
        String secondPart = input[1];
        String thirdPart = input[2];

        //1) намираме стринга с главни букви във firstPart
        //The capital letters should be surrounded from both sides
        // with any of the following symbols – "#, $, %, *, &".
        // And those symbols should match on both sides.
        String capitalLettersRegex = "([#$%*&])(?<letters>[A-Z]+)(?:\\1)";
        Pattern capitalLettersPattern = Pattern.compile(capitalLettersRegex);
        Matcher capitalLettersMatcher = capitalLettersPattern.matcher(firstPart);
        String capitalLetters = "";
        if (capitalLettersMatcher.find()) {
            capitalLetters = capitalLettersMatcher.group("letters");
        }

        //2) ASCII code на първите букви на думите и
        // дължината на думите (между 1 – 20 characters)
        //"{asciiCode}:{length}"
        //example, "67:05"
        String secondPartRegex = "(?<code>[0-9]+):(?<length>[0-9]{1,2})";
        Pattern secondPartPattern = Pattern.compile(secondPartRegex);
        Matcher secondPartMatcher = secondPartPattern.matcher(secondPart);
        //речник <индекс на първата буква в capitalLetters, дължина на думата>
        Map<Integer, Integer> wordsLength = new HashMap<>();

        while (secondPartMatcher.find()) {
            char letter = (char) Integer.parseInt(secondPartMatcher.group("code"));
            int indexOfFirstLetter = capitalLetters.indexOf(letter);
            //ako намира индекс на буквата в capitalLetters, да добави данни в речника
            if (indexOfFirstLetter != -1) {
                int wordLength = Integer.parseInt(secondPartMatcher.group("length"));
                wordsLength.put(indexOfFirstLetter, wordLength);
            }
        }

        //3)third part of the message are words separated by spaces
        //Those words have to start with the Capital letter [A…Z]
        //equal to the ASCII code and have exactly the length
        // for each capital letter you have found in the second part
        List<String> words = Arrays.stream(thirdPart.split("\\s+"))
                .collect(Collectors.toList());
        for (int index = 0; index < capitalLetters.length(); index++) {
            char firstLetter = capitalLetters.charAt(index);
            int length = wordsLength.get(index) + 1;
            String word = "";
            for (String currentWord : words) {
                if (currentWord.length() == length &&
                        currentWord.charAt(0) == firstLetter) {
                    word = currentWord;
                    System.out.println(word);
                    break;
                }
            }
            words.remove(word);
        }


//        System.out.println(capitalLetters);
//        System.out.println(wordsLength.toString());
//        System.out.println(thirdPart.toString());


    }
}
