package theme04_Methods.Exercises;

import java.util.Scanner;

public class P04_TribonacciSequence_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        ptintTribonacciSequenceToNum(num);

    }

    private static void ptintTribonacciSequenceToNum(int n) {
        int[] tribonacciSequence = new int[n];

        for (int i = 1; i <= n; i++) {
            int index = i - 1;
            if (i == 1 || i == 2) {
                tribonacciSequence[index] = 1;
            } else if (i == 3) {
                tribonacciSequence[index] = 2;
            } else if (i >= 4) {
                tribonacciSequence[index] = tribonacciSequence[index - 1] +
                        tribonacciSequence[index - 2] + tribonacciSequence[index - 3];
            }
            System.out.print(tribonacciSequence[index] + " ");
        }
    }
}