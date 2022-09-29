package tema01_BasicSyntaxConditionalStatementsAndLoops_Lab;

import java.util.Scanner;

public class sumOfOddNumbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = Integer.parseInt(scanner.nextLine());
        int currentNum = 1;
        int sumOdds = 0;

        while (counter > 0) {
            System.out.println(currentNum);
            sumOdds += currentNum;
            currentNum += 2;

            counter--;
        }
        System.out.printf("Sum: %d",sumOdds);
    }
}
