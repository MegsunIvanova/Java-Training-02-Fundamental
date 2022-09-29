package theme08_TextProcessing.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06_ReplaceRepeatingChars_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            char symbol = input[i];
            if (text.isEmpty()) {
                text.append(symbol);
            } else {
                char lastSymbol = input[i - 1];
                if (symbol != lastSymbol) {
                    text.append(symbol);
                }
            }
        }
        System.out.println(text.toString());
    }
}

