package theme04_Methods.Exercises;

import java.util.Scanner;

public class P01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        //метод, който принтира най-малкото число
        printSmallestOfThreeNumbers(number1, number2, number3);
    }

    private static void printSmallestOfThreeNumbers(int n1, int n2, int n3) {
        if (n1 <= n2 && n1 <= n3) {
            System.out.println(n1);
        } else if (n2 <= n1 && n2 <= n3) {
            System.out.println(n2);
        } else {
            System.out.println(n3);
        }
    }
}
