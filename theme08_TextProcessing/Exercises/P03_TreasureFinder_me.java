package theme08_TextProcessing.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03_TreasureFinder_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] key = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while (!input.equals("find")) {
            StringBuilder hiddenMessage = decryptMessage(input, key);
            printMessage(hiddenMessage);

            input = scanner.nextLine();
        }

    }

    private static StringBuilder decryptMessage(String input, int[] key) {
        StringBuilder hiddenMessage = new StringBuilder();
        int indexOfKey = 0;
        for (char symbol : input.toCharArray()) {
            if (indexOfKey == key.length) {
                indexOfKey = 0;
            }
            char decryptedSymbol = (char) (symbol - key[indexOfKey]);
            hiddenMessage.append(decryptedSymbol);
            indexOfKey++;
        }
        return hiddenMessage;
    }

    private static void printMessage(StringBuilder hiddenMessage) {
        String treasure = hiddenMessage.substring(hiddenMessage.indexOf("&") + 1
                , hiddenMessage.lastIndexOf("&"));
        String coordinates = hiddenMessage.substring(hiddenMessage.indexOf("<") + 1
                , hiddenMessage.lastIndexOf(">"));
        System.out.printf("Found %s at %s\n", treasure, coordinates);
    }
}
