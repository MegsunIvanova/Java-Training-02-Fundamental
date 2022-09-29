package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class reverseString_04me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.print(text.charAt(i));

        }
    }
}
