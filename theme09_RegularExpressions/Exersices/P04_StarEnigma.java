package theme09_RegularExpressions.Exersices;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(scanner.nextLine());
        Pattern starPattern = Pattern.compile("[starSTAR]+");
        String[] decryptedMessages = new String[numberOfMessages];
        Pattern patternValidMessage = Pattern.compile("@(?<planet>[A-Za-z]+)[^@\\-\\!\\:\\>]*:(?<population>\\d+)[^@\\-\\!\\:\\>]*\\!(?<attackType>[AD]?)\\![^@\\-\\!\\:\\>]*\\-\\>(?<soldiers>\\d+)");
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < numberOfMessages; i++) {
            String message = scanner.nextLine();
            //count all the letters [s, t, a, r] – case insensitive
            Matcher matcherForDecrypt = starPattern.matcher(message);
            int countStar = message.length() - matcherForDecrypt.replaceAll("").length();
            StringBuilder decryptedMessage = new StringBuilder();

            for (char symbol : message.toCharArray()) {
                char newChar = (char) (symbol - countStar);
                decryptedMessage.append(newChar);
            }
//            decryptedMessages[i] = decryptedMessage.toString();
            Matcher matcherForValidation = patternValidMessage.matcher(decryptedMessage.toString());
            if (matcherForValidation.find()) {
                String planet = matcherForValidation.group("planet");
                String attackType = matcherForValidation.group("attackType");
                if (attackType.equals("A")) {
                    attackedPlanets.add(planet);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(planet);
                }
            }
        }
        if (attackedPlanets.isEmpty()) {
            System.out.println("Attacked planets: 0");
        } else {
            Collections.sort(attackedPlanets);
            System.out.printf("Attacked planets: %d\n-> ", attackedPlanets.size());
            System.out.println(String.join("\n-> ", attackedPlanets));

        }

        if (destroyedPlanets.isEmpty()) {
            System.out.println("Destroyed planets: 0");
        } else {
            Collections.sort(destroyedPlanets);
            System.out.printf("Destroyed planets: %d\n-> ", destroyedPlanets.size());
            System.out.println(String.join("\n-> ", destroyedPlanets));
        }
    }
}
