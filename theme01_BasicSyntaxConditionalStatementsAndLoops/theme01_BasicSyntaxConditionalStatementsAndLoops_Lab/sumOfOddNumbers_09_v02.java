package tema01_BasicSyntaxConditionalStatementsAndLoops_Lab;

import java.util.Scanner;

public class sumOfOddNumbers_09_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sumOdds = 0;

        for (int i = 1; i <= num * 2; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                sumOdds += i;
            }
        }
        System.out.printf("Sum: %d", sumOdds);
    }
}
