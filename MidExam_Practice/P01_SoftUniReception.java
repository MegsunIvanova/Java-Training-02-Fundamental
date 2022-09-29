package MidExam_Practice;

import java.util.Scanner;

public class P01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalStudentsPerHour = 0;
        for (int i = 1; i <= 3; i++) {
            int employeeEfficiency = Integer.parseInt(scanner.nextLine());
            totalStudentsPerHour += employeeEfficiency;
        }
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int hourCounter = 0;

        while (studentsCount > 0) {
            hourCounter++;
            if (hourCounter % 4 == 0) {
                continue;
            }
            if (studentsCount >= totalStudentsPerHour) {
                studentsCount -= totalStudentsPerHour;
            } else {
                studentsCount = 0;
            }
        }
        System.out.printf("Time needed: %dh.", hourCounter);

    }
}
