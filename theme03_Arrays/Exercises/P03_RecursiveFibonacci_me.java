package theme03_Arrays.Exercises;

import java.util.Scanner;

public class P03_RecursiveFibonacci_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        if (n < 3) {
            System.out.println(1);
        } else {
            int prevFibonacci = 1;
            int nextFibonacci = 1;
            int sum = 0;
            for (int i = 3; i <= n; i++) {
                sum = prevFibonacci + nextFibonacci;
                prevFibonacci = nextFibonacci;
                nextFibonacci = sum;
            }
            System.out.println(sum);
        }
    }
}
