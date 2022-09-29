package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(scanner.nextLine());

        for (int firstIndex = 0; firstIndex < numArr.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < numArr.length; secondIndex++) {
                if (numArr[firstIndex] + numArr[secondIndex] == sum) {
                    System.out.println(numArr[firstIndex] + " " + numArr[secondIndex]);
                }
            }
        }
    }
}
