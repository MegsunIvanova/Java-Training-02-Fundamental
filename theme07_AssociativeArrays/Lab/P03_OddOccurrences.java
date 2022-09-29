package theme07_AssociativeArrays.Lab;

import java.util.*;

public class P03_OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineInput = scanner.nextLine().split(" ");
        Map<String, Integer> wordsCountMap = new LinkedHashMap<>();

        for (String word : lineInput) {
            String currentWord = word.toLowerCase();
            wordsCountMap.putIfAbsent(currentWord, 0);
            int newValue = wordsCountMap.get(currentWord) + 1;
            wordsCountMap.put(currentWord, newValue);
        }

        List <String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
               oddWords.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", oddWords));


    }
}
