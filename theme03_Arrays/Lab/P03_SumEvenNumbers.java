package theme03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberArea = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumEven = 0;
        for (int i = 0; i < numberArea.length; i++) {
            int currentElement = numberArea[i];
            if (currentElement % 2 == 0) {
                sumEven += currentElement;
            }
        }

        System.out.println(sumEven);
    }
}
