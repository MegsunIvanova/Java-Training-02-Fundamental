package theme07_AssociativeArrays.Exercises;

import java.util.*;

public class P01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charsArr = scanner.nextLine().replace(" ", "").toCharArray();
        Map<Character, Integer> countCharsMap = new LinkedHashMap<>();
        for (char currentChar : charsArr) {
            countCharsMap.putIfAbsent(currentChar, 0);
            countCharsMap.put(currentChar, countCharsMap.get(currentChar) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countCharsMap.entrySet()) {
                  System.out.printf("%c -> %d\n",entry.getKey(),entry.getValue());
        }

    }
}
