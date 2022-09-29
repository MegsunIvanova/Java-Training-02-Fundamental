package theme03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < numArr.length; i++) {
            int currentElement = numArr[i];
            if (currentElement % 2 == 0) {
                sumEven += currentElement;
            } else {
                sumOdd += currentElement;
            }
        }
        System.out.println(sumEven - sumOdd);
    }
}
