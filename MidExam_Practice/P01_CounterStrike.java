package MidExam_Practice;

import java.util.Scanner;

public class P01_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int wonBattles = 0;
        boolean isRunOutOfEnergy = false;
        String input = scanner.nextLine();

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (distance <= energy) {
                energy -= distance;
                wonBattles++;
                if (wonBattles % 3 == 0) {
                    energy += wonBattles;
                }
            } else {
                isRunOutOfEnergy = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (isRunOutOfEnergy) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy"
                    , wonBattles, energy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d"
                    , wonBattles, energy);
        }

    }
}
