package theme08_TextProcessing.Lab;

import java.util.Scanner;

public class P03_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //On the first line, you will receive a string.
        String toRemove = scanner.nextLine();
        // On the second line, you will receive a second string.
        String resultString = scanner.nextLine();
        // Write a program that removes all of the occurrences of
        // the first string in the second until there is no match.

        while (resultString.contains(toRemove)) {
            resultString = resultString.replace(toRemove, "");
        }
        System.out.println(resultString);

        // At the end print the remaining string.
    }
}