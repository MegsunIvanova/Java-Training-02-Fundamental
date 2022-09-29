package theme04_Methods.Lab;

import java.util.Scanner;

public class LiveExample2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double grade = Double.parseDouble(scanner.nextLine());

        printDataStudents(name, age, grade);
    }

    public static void printDataStudents(String name, int age, double grade) {
        System.out.printf("Student: %s; Age: %d, Grade: %.2f\n", name, age, grade);
    }
}
