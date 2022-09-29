package theme04_Methods.Exercises;

import java.util.Locale;
import java.util.Scanner;

public class P02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase(Locale.ROOT);
        printVowelsCount (text);

    }

    private static void printVowelsCount(String text) {
        int count = 0;
        for (char symbol : text.toCharArray()) {

            //а, е, i, o, u
            //"Desi".toCharArray () -> ['D','e','s','i']
            if (symbol == 'a' || symbol == 'e'
                    || symbol == 'i' || symbol == 'o'
                    || symbol == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }
}
