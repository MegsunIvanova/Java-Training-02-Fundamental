package theme04_Methods.Exercises;

import java.util.Scanner;

public class P05_MultiplicationSign_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = new int[3];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(scanner.nextLine());
        }

        printNumArrProductSign(numArr);

    }

    private static void printNumArrProductSign(int[] numArr) {

        boolean isNumArrContainsZero = false;
        int countNegativeElements = 0;
        for (int element : numArr) {
            if (element < 0) {
                countNegativeElements++;
            } else if (element == 0) {
                isNumArrContainsZero = true;
                break;
            }
        }

        if (isNumArrContainsZero) {
            System.out.println("zero");
        } else if (countNegativeElements % 2 != 0) {
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }

    }
}
