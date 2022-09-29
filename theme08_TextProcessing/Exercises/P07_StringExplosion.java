package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder();
        int strength = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '>') {
                strength += Integer.parseInt(String.valueOf(input.charAt(i + 1))) - 1;
                text.append(symbol);
                i++;

            } else {
                if (strength > 0) {
                    strength--;
                } else {
                    text.append(symbol);
                }
            }
        }
        System.out.println(text.toString());
    }
}
