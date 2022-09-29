package MidExam_Practice;

import java.util.Scanner;

public class P01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int totalNumberOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = 0;
        int attendanceOfMaxBonusStudent = 0;

        for (int studentNumber = 1; studentNumber <= students; studentNumber++) {
            //The bonus is calculated with the following formula:
            //{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})
            int attendance = Integer.parseInt(scanner.nextLine());

            double bonus = attendance * 1.0 / totalNumberOfLectures * (5 + additionalBonus);

            if (bonus > maxBonus) {
                maxBonus = bonus;
                attendanceOfMaxBonusStudent = attendance;
            }

        }

        System.out.printf("Max Bonus: %.0f.\n" +
                "The student has attended %d lectures.\n", maxBonus, attendanceOfMaxBonusStudent);


    }
}
