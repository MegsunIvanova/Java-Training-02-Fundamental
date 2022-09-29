package theme09_RegularExpressions.Exersices;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_SantaSSecretHelper_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behavior>[GN])!";
        Pattern pattern = Pattern.compile(regex);

        String message = scanner.nextLine();
        while (!message.equals("end")) {
            //decode by subtracting the key from the value of each character
            String decryptedMessage = decodeMessage(key, message);

            //a valid decryptedMessage have:
            //name, which starts after '@' and contains only letters from the Latin alphabet
            //behavior type - "G"(good) or "N"(naughty) and must be surrounded by "!"
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                String name = matcher.group("name");
                String behavior = matcher.group("behavior");
                if (behavior.equals("G")) {
                    System.out.println(name);
                }
            }

            message = scanner.nextLine();
        }
    }

    private static String decodeMessage(int key, String message) {
        StringBuilder decodedMessage = new StringBuilder();
        for (char symbol : message.toCharArray()) {
            char decodedSymbol = (char) (symbol - key);
            decodedMessage.append(decodedSymbol);
        }
        return decodedMessage.toString();
    }
}
