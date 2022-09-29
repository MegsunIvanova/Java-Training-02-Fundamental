package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder();
        String lastSymbol = "";
        for (char symbol : input.toCharArray()) {
            if (text.length() == 0) {
                text.append(symbol);
            } else {
                if (text.charAt(text.length() - 1) != symbol) {
                    text.append(symbol);
                }
            }
        }
        System.out.println(text.toString());
    }
}

