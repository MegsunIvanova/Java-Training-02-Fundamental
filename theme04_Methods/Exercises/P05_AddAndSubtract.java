package theme04_Methods.Exercises;

import java.util.Scanner;

public class P05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int result = subtractFromSum(num1, num2, num3);
        System.out.println(result);


    }

    private static int getSum(int n1, int n2) {
        return n1 + n2;
    }

    private static int subtractFromSum(int n1, int n2, int n3) {
        return getSum(n1, n2) - n3;
    }
}
