package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int maxLength = 1;
        int startIndexMaxLength = 0;

        for (int index = 0; index < numArr.length; index++) {
            int currentElement = numArr[index];
            int currentLength = 1;
            for (int nextIndex = index + 1; nextIndex < numArr.length; nextIndex++) {
                int nextElement = numArr[nextIndex];
                if (currentElement == nextElement) {
                    currentLength++;
                } else {
                    break;
                }
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                startIndexMaxLength = index;
            }
        }

        for (int i = startIndexMaxLength; i < startIndexMaxLength+maxLength; i++) {
            System.out.print(numArr[i] + " ");
        }

    }
}
