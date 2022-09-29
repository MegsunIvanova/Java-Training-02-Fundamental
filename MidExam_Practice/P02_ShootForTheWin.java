package MidExam_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetsValue = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] isShot = new boolean[targetsValue.length];
        int countShots = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int indexOfTheTargetToBeShot = Integer.parseInt(input);
            if (indexOfTheTargetToBeShot >= 0
                    && indexOfTheTargetToBeShot < targetsValue.length
                    && !isShot[indexOfTheTargetToBeShot]) {
                int value = targetsValue[indexOfTheTargetToBeShot];
                targetsValue[indexOfTheTargetToBeShot] = -1;
                isShot[indexOfTheTargetToBeShot] = true;
                countShots++;
                for (int i = 0; i < targetsValue.length; i++) {
                    if (i == indexOfTheTargetToBeShot) {
                        continue;
                    } else if (targetsValue[i] > value && !isShot[i]) {
                        targetsValue[i] -= value;
                    } else if (targetsValue[i] <= value && !isShot[i]) {
                        targetsValue[i] += value;
                    }
                }

            }

            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", countShots);
        System.out.print(Arrays.toString (targetsValue)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));

    }
}
