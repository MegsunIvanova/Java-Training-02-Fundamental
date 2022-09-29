package theme04_Methods.Lab;

import java.util.Scanner;

public class P06_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Integer.parseInt(scanner.nextLine());
        double length = Integer.parseInt(scanner.nextLine());
        double area = calculateRectangleArea(width, length);

        System.out.printf("%.0f", area);
    }

    public static double calculateRectangleArea(double width, double length) {
        return width * length;

    }
}
