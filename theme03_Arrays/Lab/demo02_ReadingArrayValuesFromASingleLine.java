package theme03_Arrays.Lab;

import java.util.Scanner;

public class demo02_ReadingArrayValuesFromASingleLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"1 2 3 4 5"
        String inputLine = scanner.nextLine();
        String[] arrStrings = inputLine.split(" ");

        int[] numbersArr = new int[arrStrings.length];

        for (int i = 0; i < numbersArr.length; i++) {
            numbersArr[i] = Integer.parseInt(arrStrings[i]);
        }


    }
}
