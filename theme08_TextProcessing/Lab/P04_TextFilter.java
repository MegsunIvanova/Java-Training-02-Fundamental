package theme08_TextProcessing.Lab;

import java.util.Scanner;

public class P04_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] banWordsArr = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String banWord : banWordsArr) {
            if (text.contains(banWord)) {
                text = text.replace(banWord, repeatStr("*", banWord.length()));
            }
        }
        System.out.println(text);
    }

    private static String repeatStr(String s, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += s;
        }
        return result;

    }
}
