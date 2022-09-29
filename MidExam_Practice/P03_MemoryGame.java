package MidExam_Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine()
                .split(" ")).collect(Collectors.toList());
        boolean isPlayerWinning = false;
        int moves = 0;

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            int[] indexes = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            moves++;
            int firstIndex = indexes[0];
            int secondIndex = indexes[1];

            if (firstIndex == secondIndex
                    || firstIndex < 0 || firstIndex > elements.size() - 1
                    || secondIndex < 0 || secondIndex > elements.size() - 1) {
                //If the player tries to cheat:
                String newElement = "-" + moves + "a";
                int middleIndex = elements.size() / 2;
                elements.addAll(middleIndex, Arrays.asList(newElement, newElement));
                System.out.println("Invalid input! Adding additional elements to the board");

            } else {
                if (elements.get(firstIndex).equals(elements.get(secondIndex))) {
                    //if player hit two matching elements
                    String element = elements.get(firstIndex);
                    elements.removeAll(Arrays.asList(element));
                    System.out.printf("Congrats! You have found matching elements - %s!\n", element);

                } else {
                    //if player hit two different elements
                    System.out.println("Try again!");
                }
            }
            if (elements.size() == 0) {
                //player win
                isPlayerWinning = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (isPlayerWinning) {
            System.out.printf("You have won in %d turns!", moves);
        } else {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", elements));
        }

    }
}
