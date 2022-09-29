package theme08_TextProcessing.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Write a Program That Reads an Array of Strings.
        String[] arr = scanner.nextLine().split(" ");
        List<String> repeatList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // Each String is Repeated N Times,
            // Where N is the length of the String.
            // Print the Concatenated String.
            String currentWord = arr[i];
            int len = currentWord.length();
            String repeatWord = repeatString(currentWord,len);
            repeatList.add(repeatWord);
        }
        System.out.println(String.join("",repeatList));
    }

    public static String repeatString(String s, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += s;
        }
        return result;
    }
}
