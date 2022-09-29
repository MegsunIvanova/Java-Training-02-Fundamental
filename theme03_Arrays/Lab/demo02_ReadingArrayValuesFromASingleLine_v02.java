package theme03_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class demo02_ReadingArrayValuesFromASingleLine_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"1 2 3 4 5"
        int [] numArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double [] numDouble = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        //или
        String[] arrStrings = scanner.nextLine().split(" ");

        int[] numbersArr = new int[arrStrings.length];

        for (int i = 0; i < numbersArr.length; i++) {
            numbersArr[i] = Integer.parseInt(arrStrings[i]);
        }


    }
}
