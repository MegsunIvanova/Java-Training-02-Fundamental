package theme04_Methods.Lab;

import java.util.Scanner;

public class P02_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());
        printGradeInWords(grade);
    }

    public static void printGradeInWords(double grade) {
        if (grade >= 2.0 && grade < 3.0) {
            System.out.println("Fail");
        } else if (grade >= 3.0 && grade < 3.5) {
            System.out.println("Poor");
        } else if (grade >= 3.5 && grade < 4.5) {
            System.out.println("Good");
        } else if (grade >= 4.5 && grade < 5.5) {
            System.out.println("Very good");
        } else if (grade >= 5.5 && grade < 6.0) {
            System.out.println("Excellent");
        }
    }
}
