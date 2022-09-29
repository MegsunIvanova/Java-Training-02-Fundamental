package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P04_CaesarCipher_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (int position = 0; position < text.length(); position++) {
            char symbol = text.charAt(position);
            char encryptedSymbol = (char) (symbol + 3);
            encryptedText.append(encryptedSymbol);
        }

        System.out.println(encryptedText);
    }
}
