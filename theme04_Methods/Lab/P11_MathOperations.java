package theme04_Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        double secondNum = Double.parseDouble(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println(df.format(calculate(firstNum, operator, secondNum)));

    }

    public static double calculate(double firstNum, char operator, double secondNum) {
        double result = 0;
        switch (operator) {
            case '/':
                result = divisionCalculation(firstNum, secondNum);
                break;
            case '*':
                result = multiplicationCalculation(firstNum, secondNum);
                break;
            case '+':
                result = additionCalculation(firstNum, secondNum);
                break;
            case '-':
                result = subtractionCalculation(firstNum, secondNum);
                break;
        }
        return result;
    }

    public static double divisionCalculation(double firstNum, double secondNum) {
        double result = 0;
        if (secondNum != 0) {
            result = firstNum / secondNum;
        }
        return result;
    }

    public static double multiplicationCalculation(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }

    public static double subtractionCalculation(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }

    public static double additionCalculation(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }
}
