package MidExam_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class P02_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isEmptySpots = false;

        for (int i = 0; i < lift.length; i++) {
            int emptySpots = 4 - lift[i];
            if (people > emptySpots) {
                people -= emptySpots;
                lift[i] = 4;
            } else {
                lift[i] += people;
                people = 0;
            }
            if (lift[i] < 4) {
                isEmptySpots = true;
            }
        }

        if (people > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", people);
        } else if (isEmptySpots) {
            System.out.println("The lift has empty spots!");
        }
        System.out.println(Arrays.toString(lift)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));

    }
}
