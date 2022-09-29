package theme03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05_EvenAndOddSubtraction_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int evenSum = 0;
        int oddSum = 0;

        //foreach loop
        for (int currentElement : numArr) {
            if (currentElement % 2 == 0) {
                evenSum += currentElement;
            } else {
                oddSum += currentElement;
            }
        }

        System.out.println(evenSum - oddSum);
    }
}
