package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class sortNumbers_01me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Read three real numbers and sort them in descending order.
        //Print each number on a new line.

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int minNum = 0;
        int middleNum = 0;
        int maxNum = 0;

        if (num1 > num2 && num1 > num3) {
            maxNum = num1;
            if (num2 > num3) {
                middleNum = num2;
                minNum = num3;
            } else {
                middleNum = num3;
                minNum = num2;
            }
        } else if (num2 > num1 && num2 > num3) {
            maxNum = num2;
            if (num1 > num3) {
                middleNum = num1;
                minNum = num3;
            } else {
                middleNum = num3;
                minNum = num1;
            }
        } else {
            maxNum = num3;
            if (num2 > num1) {
                middleNum = num2;
                minNum = num1;
            } else {
                middleNum = num1;
                minNum = num2;
            }
        }
        System.out.println(maxNum);
        System.out.println(middleNum);
        System.out.println(minNum);
    }
}
