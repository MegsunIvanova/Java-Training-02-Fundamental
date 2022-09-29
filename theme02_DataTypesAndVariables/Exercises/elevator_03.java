package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class elevator_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        double courses = Math.ceil(number * 1.0 / capacity);

        System.out.printf("%.0f", courses);
    }
}
