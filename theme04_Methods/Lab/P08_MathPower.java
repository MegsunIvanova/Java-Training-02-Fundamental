package theme04_Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        double result = powerCalculation(number, power);

        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(result));
    }

    public static double powerCalculation(double number, int power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result = result*number;
        }
        return result;
    }
}
