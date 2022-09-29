package theme07_AssociativeArrays.Lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, ArrayList<String>> wordsMap = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            wordsMap.putIfAbsent(word, new ArrayList<>());
            wordsMap.get(word).add(synonym);

        }

        for (Map.Entry<String, ArrayList<String>> entry : wordsMap.entrySet()) {
            String entryValueToString = String.join(", ", entry.getValue());
            System.out.printf("%s - %s\n", entry.getKey(), entryValueToString);
        }


    }
}
