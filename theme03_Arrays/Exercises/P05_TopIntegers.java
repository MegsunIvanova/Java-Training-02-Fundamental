package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < numArr.length; index++) {
            boolean isTopInt = true;
            int nextIndex = index + 1;
            while (nextIndex < numArr.length) {
                if (numArr[nextIndex] >= numArr[index]) {
                    isTopInt = false;
                    break;
                }
                nextIndex++;
            }
            if (isTopInt) {
                System.out.print(numArr[index] + " ");
            }
        }

    }
}
