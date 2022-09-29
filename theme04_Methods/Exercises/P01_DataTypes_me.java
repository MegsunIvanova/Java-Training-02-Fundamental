package theme04_Methods.Exercises;

import java.util.Scanner;

public class P01_DataTypes_me {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        switch (input) {
            case "int":
                int number = Integer.parseInt(scanner.nextLine());
                printNumberMultipliedByTwo(number);
                break;
            case "real":
                double realNum = Double.parseDouble(scanner.nextLine());
                printRealNumberMultipliedByOneAndHalf(realNum);
                break;
            case "string":
                String text = scanner.nextLine();
                printStringSurroundedWith$(text);
                break;
        }
    }

    private static void printNumberMultipliedByTwo(int number) {
        int result = number * 2;
        System.out.println(result);

    }

    private static void printRealNumberMultipliedByOneAndHalf(double number) {
        double result = number * 1.5;
        System.out.printf("%.2f\n", result);
    }

    private static void printStringSurroundedWith$(String text) {
        System.out.printf("$%s$\n", text);
    }
}
