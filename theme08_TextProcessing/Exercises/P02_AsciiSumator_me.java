package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P02_AsciiSumator_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        if (secondSymbol < firstSymbol) {
            char tempSymbol = secondSymbol;
            secondSymbol = firstSymbol;
            firstSymbol = tempSymbol;
        }
        String text = scanner.nextLine();

        int sum = 0;
        for (char symbol : text.toCharArray()) {
            if (symbol > firstSymbol && symbol < secondSymbol) {
                sum += (int) symbol;
            }
        }
        System.out.println(sum);
    }
}
