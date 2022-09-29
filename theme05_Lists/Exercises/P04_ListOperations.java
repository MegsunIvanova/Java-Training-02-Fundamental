package theme05_Lists.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            List<String> commandLine = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());

            String command = commandLine.get(0);

            switch (command) {
                case "Add":
                    //•	Add {number} - add number at the end
                    int numberToAdd = Integer.parseInt(commandLine.get(1));
                    numbers.add(numbers.size(), numberToAdd);
                    break;
                case "Insert":
                    //•	Insert {number} {index} - insert number at given index
                    int numberToInsert = Integer.parseInt(commandLine.get(1));
                    int insertAtIndex = Integer.parseInt(commandLine.get(2));
                    insertNumberAtIndex(numberToInsert, insertAtIndex, numbers);
                    break;
                case "Remove":
                    //•	Remove {index} - remove that index
                    int removeIndex = Integer.parseInt(commandLine.get(1));
                    removeIndex(removeIndex, numbers);
                    break;
                case "Shift":
                    String direction = commandLine.get(1);
                    int count = Integer.parseInt(commandLine.get(2));
                    shiftList(numbers, direction, count);

                    break;

            }

            input = scanner.nextLine();
        }

        System.out.println(numbers.toString()
                .replaceAll("[\\[\\],]", ""));

    }

    private static void shiftList(List<Integer> numList, String direction, int count) {
        if (direction.equals("left")) {
            //•	Shift left {count} - first number becomes last 'count' times
            for (int i = 1; i <= count; i++) {
                int oldNumberAtFirstIndex = numList.get(0);
                numList.remove(0);
                numList.add(numList.size(), oldNumberAtFirstIndex);
            }
        } else if (direction.equals("right")) {
            //•	Shift right {count} - last number becomes first 'count' times
            for (int i = 1; i <= count; i++) {
                int oldNumberAtLastIndex = numList.get(numList.size() - 1);
                numList.remove(numList.size() - 1);
                numList.add(0,oldNumberAtLastIndex);
            }
        }
    }

    private static void removeIndex(int index, List<Integer> numList) {
        if (isIndexInsideOfTheBounds(index, numList)) {
            numList.remove(index);
        }
    }

    private static void insertNumberAtIndex(int number, int index, List<Integer> numList) {
        if (isIndexInsideOfTheBounds(index, numList)) {
            numList.add(index, number);
        }
    }

    private static boolean isIndexInsideOfTheBounds(int index, List<Integer> numList) {
        if (index < 0 || index > numList.size() - 1) {
            System.out.println("Invalid index");
            return false;
        } else {
            return true;
        }
    }
}
