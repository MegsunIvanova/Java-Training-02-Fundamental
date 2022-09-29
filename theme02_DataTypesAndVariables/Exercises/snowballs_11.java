package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowballsNum = Integer.parseInt(scanner.nextLine());

        double maxValue = Double.MIN_VALUE;
        int maxSnow = 0;
        int maxTime = 0;
        int maxQuality = 0;

        for (int i = 1; i <= snowballsNum; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            if (snowballTime > 0) {
                double snowballValue = Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality * 1.0);

                if (snowballValue > maxValue) {
                    maxValue = snowballValue;
                    maxSnow = snowballSnow;
                    maxTime = snowballTime;
                    maxQuality = snowballQuality;
                }
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnow, maxTime, maxValue, maxQuality);
    }
}