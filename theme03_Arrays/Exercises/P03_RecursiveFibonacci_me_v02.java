package theme03_Arrays.Exercises;

import java.util.Scanner;

public class P03_RecursiveFibonacci_me_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getFibonacci(n));
    }

    public static int getFibonacci(int number) {
        if (number <= 2) {
            return 1;
        }
        return getFibonacci(number - 1) + getFibonacci(number - 2);
    }
}

