package theme04_Methods.Exercises;

import java.util.Scanner;

public class P08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        //1.намиране на факториела на number1
        long fact1 = getFactorial(number1);

        //2.намиране на факториела на number2
        long fact2 = getFactorial(number2);

        //факториела на number1 / факториела на number2 -> %.2f
        System.out.printf("%.2f", fact1 * 1.0 / fact2);

    }

    //метод за изчисляване н факториел
    private static long getFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
