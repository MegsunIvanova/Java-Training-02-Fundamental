package theme03_Arrays.Lab;

import java.util.Scanner;

public class P02_PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numberArea = new int[n];

        for (int i = 0; i < numberArea.length; i++) {
            numberArea[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = numberArea.length - 1; i >= 0; i--) {
            System.out.print(numberArea[i] + " ");
        }
    }
}
