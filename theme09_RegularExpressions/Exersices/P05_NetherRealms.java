package theme09_RegularExpressions.Exersices;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] demonsNames = scanner.nextLine().split("(\\s)*,(\\s)*");
        for (int i = 0; i < demonsNames.length; i++) {
            String demonName = demonsNames[i];
            int demonHealth = getHealth(demonName);
            double demonDamage = getDamage(demonName);
            System.out.printf("%s - %d health, %.2f damage\n", demonName, demonHealth, demonDamage);
        }

    }

    private static int getHealth(String demonName) {
        int demonHealth = 0;
        //sum of the asci codes of all characters
        //excluding numbers (0-9),
        // arithmetic symbols ('+', '-', '*', '/') and
        // delimiter dot ('.')
        String regex = "[^0-9+\\-*/.]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(demonName);
        while (matcher.find()) {
            demonHealth += matcher.group().charAt(0);
        }
        return demonHealth;
    }

    private static double getDamage(String demonName) {
        double demonDamage = 0;
        //1) sum of all numbers
        //2) you should consider the plus '+' and minus '-'
        //3) some symbols ('*' and '/') that can further alter the base damage
        // by multiplying or dividing it by 2

        //1) намираме сумата на всички числа съобразявайки '+' и '-'
        String regexSum = "[+-]*[0-9]+(\\.?[0-9]+)*";
        Pattern patternSum = Pattern.compile(regexSum);
        Matcher matcherSum = patternSum.matcher(demonName);
        while (matcherSum.find()) {
            demonDamage += Double.parseDouble(matcherSum.group());
        }

        //проверяваме за наличие на '*' или '/' и умножаваме или делим сумата на 2
        String regexMultiplyOrDivide = "[*\\/]";
        Pattern patternMultiplyOrDivide = Pattern.compile(regexMultiplyOrDivide);
        Matcher matcherMultiplyOrDivide = patternMultiplyOrDivide.matcher(demonName);
        while (matcherMultiplyOrDivide.find()) {
            if (matcherMultiplyOrDivide.group().equals("*")) {
                demonDamage *= 2;
            } else if (matcherMultiplyOrDivide.group().equals("/")) {
                demonDamage /= 2;
            }
        }

        return demonDamage;
    }
}
