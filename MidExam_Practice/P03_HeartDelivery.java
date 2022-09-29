package MidExam_Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> neighborhood = Arrays.stream(scanner.nextLine()
                .split("@")).map(Integer::parseInt).collect(Collectors.toList());
        int currentCupidIndex = 0;

        String jumpCommand = scanner.nextLine();

        while (!jumpCommand.equals("Love!")) {
            int jumpLength = Integer.parseInt(jumpCommand.split(" ")[1]);
            currentCupidIndex += jumpLength;

            //if Cupid does jump outside of neighborhood,
            // he should start from the first house again (index 0)
            if (currentCupidIndex > neighborhood.size() - 1) {
                currentCupidIndex = 0;
            }
            int houseHearts = neighborhood.get(currentCupidIndex);

            //the needed hearts for the visited house are decreased by 2
            if (houseHearts > 2) {
                neighborhood.set(currentCupidIndex, houseHearts - 2);

            } else if (houseHearts == 2) {
                //•	If the needed hearts for a certain house become equal to 0
                neighborhood.set(currentCupidIndex, 0);
                System.out.printf("Place %d has Valentine's day.\n", currentCupidIndex);
            } else if (houseHearts == 0) {
                //•	If Cupid jumps to a house where the needed hearts are already 0
                System.out.printf("Place %d already had Valentine's day.\n", currentCupidIndex);
            }

            jumpCommand = scanner.nextLine();

        }

        System.out.printf("Cupid's last position was %d.\n", currentCupidIndex);

        int houseWithoutCelebration = 0;
        for (Integer hearts : neighborhood) {
            if (hearts > 0) {
                houseWithoutCelebration++;
            }
        }
        if (houseWithoutCelebration == 0) {
            //•	If each house has had Valentine's day
            System.out.println("Mission was successful.");
        } else {
            //•	If not, print the count of all houses that
            // didn't celebrate Valentine's Day
            System.out.printf("Cupid has failed %d places.", houseWithoutCelebration);
        }

    }
}
