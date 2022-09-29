package theme08_TextProcessing.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P04_MorseCodeTranslator_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Character> morseCode = new HashMap<>();
        morseCode.put(".-", 'A');
        morseCode.put("-...", 'B');
        morseCode.put("-.-.", 'C');
        morseCode.put("-..", 'D');
        morseCode.put(".", 'E');
        morseCode.put("..-.", 'F');
        morseCode.put("--.", 'G');
        morseCode.put("....", 'H');
        morseCode.put("..", 'I');
        morseCode.put(".---", 'J');
        morseCode.put("-.-", 'K');
        morseCode.put(".-..", 'L');
        morseCode.put("--", 'M');
        morseCode.put("-.", 'N');
        morseCode.put("---", 'O');
        morseCode.put(".--.", 'P');
        morseCode.put("--.-", 'Q');
        morseCode.put(".-.", 'R');
        morseCode.put("...", 'S');
        morseCode.put("-", 'T');
        morseCode.put("..-", 'U');
        morseCode.put("...-", 'V');
        morseCode.put(".--", 'W');
        morseCode.put("-..-", 'X');
        morseCode.put("-.--", 'Y');
        morseCode.put("--..", 'Z');

        String[] morseCodedMessage = scanner.nextLine().split(" \\| ");
        List<String> decryptedMessage = new ArrayList<>();

        for (String code : morseCodedMessage) {
            List<String> word = Arrays.stream(code.split(" ")).collect(Collectors.toList());
            word.replaceAll(e -> "" + morseCode.get(e));
            decryptedMessage.add(String.join("", word));
        }
        System.out.println(String.join(" ",decryptedMessage));
    }
}
