package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P07_StringExplosion_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);

        int strength = 0;
        for (int position = 0; position < text.length(); position++) {
            char currentSymbol = text.charAt(position);
            if (currentSymbol == '>') {
                //атака
                int attackStrength = Integer.parseInt(text.charAt(position + 1) + "");//сила на атаката
                strength += attackStrength;
            } else if (currentSymbol != '>' && strength > 0) {
                text.deleteCharAt(position);
                position--;
                strength--;
            }
        }

        System.out.println(text.toString());
    }
}
