package theme03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04_ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strArr = scanner.nextLine().split(" ");

        for (int i = 0; i < strArr.length / 2; i++) {
            String oldElement = strArr[i];
            strArr[i] = strArr[strArr.length - 1 - i];
            strArr[strArr.length - 1 - i] = oldElement;
        }

        for (int i = 0; i < strArr.length; i++) {
            String currentElement = strArr[i];
            System.out.print(currentElement + " ");

        }
    }
}
