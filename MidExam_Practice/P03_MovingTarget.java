package MidExam_Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];
            int index = Integer.parseInt(commandLine[1]);
            if (command.equals("Shoot")) {
                //•	"Shoot {index} {power}"
                int power = Integer.parseInt(commandLine[2]);
                //index validation:
                if (index >= 0 && index < targets.size()) {
                    int currentTargetValue = targets.get(index);
                    //reducing target value
                    if (power < currentTargetValue) {
                        targets.set(index, (currentTargetValue - power));
                    } else { //remove target if it is shot (when its value reaches 0)
                        targets.remove(index);
                    }
                }

            } else if (command.equals("Add")) {
                //•	"Add {index} {value}"
                int value = Integer.parseInt(commandLine[2]);
                //index validation:
                if (index >= 0 && index < targets.size()) {
                    //valid index -> Insert a target
                    targets.add(index, value);
                } else {
                    //if index is not valid
                    System.out.println("Invalid placement!");
                }

            } else if (command.equals("Strike")) {
                //•	"Strike {index} {radius}"
                int radius = Integer.parseInt(commandLine[2]);
                int fromIndex = index - radius;
                int toIndex = index + radius + 1;
                //index of sublist validation
                if (fromIndex >= 0 && toIndex <= targets.size()) {
                    targets.subList(fromIndex, toIndex).clear();
                } else {
                    //if are not valid
                    System.out.println("Strike missed!");
                }

            }
            input = scanner.nextLine();
        }

        System.out.println(targets.toString()
                .replaceAll("[\\[,\\],\\,]", "")
                .replace(" ", "|"));
    }
}
