package theme05_Lists.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_DrumSet_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> initialDrumsQuality = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumsQuality = new ArrayList<>(initialDrumsQuality);

        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            //decreasing the value of drum's quality with the hitPower:
            for (int index = 0; index < drumsQuality.size(); index++) {
                int currentDrumQuality = drumsQuality.get(index);
                if (currentDrumQuality - hitPower > 0) {
                    drumsQuality.set(index,currentDrumQuality-hitPower);
                } else {
                    //drum breaks
                    //the price of new drum is {initialQuality} * 3
                    double drumPrice = initialDrumsQuality.get(index) * 3;

                    if (drumPrice <= savings) {
                        //if she can afford to buy a new drum
                        savings -= drumPrice;
                        drumsQuality.set(index, initialDrumsQuality.get(index));
                    } else {
                        //if she can't afford to buy a new drum -> the broken drum is removed
                        initialDrumsQuality.remove(index);
                        drumsQuality.remove(index);
                        index--;
                    }
                }
            }

            input = scanner.nextLine();
        }


        //drum set, separated by space
        System.out.println(drumsQuality.toString()
                .replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
