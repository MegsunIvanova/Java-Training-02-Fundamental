package theme03_Arrays.Exercises;

import java.util.Scanner;

public class P03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        for (int row = 1; row <= n; row++) {
            String numbers = scanner.nextLine();
            int firstNum = Integer.parseInt(numbers.split(" ")[0]);
            int secondNum =Integer.parseInt(numbers.split(" ")[1]);
            if (row % 2 == 0) {
                firstArr[row - 1] = secondNum;
                secondArr[row - 1] = firstNum;
            } else {
                firstArr[row - 1] = firstNum;
                secondArr[row - 1] = secondNum;
            }

        }

        for (int element : firstArr) {
            System.out.print(element+" ");
        }
        System.out.println();
        for (int element : secondArr) {
            System.out.print(element+" ");
        }
    }
}
