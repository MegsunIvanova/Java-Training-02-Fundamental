package theme05_Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            String command = commandLine.get(0);
            int item = 0;
            switch (command) {
                case "Add":
                    //Add {number}: add a number to the end of the list
                    item = Integer.parseInt(commandLine.get(1));
                    numList.add(item);
                    break;
                case "Remove":
                    //Remove {number}: remove a number from the list
                    item = Integer.parseInt(commandLine.get(1));
                    numList.remove(Integer.valueOf(item));
                    //по този начин го превръщаме в обект и няма риск числото да го сметне за индекс
                    break;
                case "RemoveAt":
                    //RemoveAt {index}: remove a number at a given index
                    item = Integer.parseInt(commandLine.get(1));
                    numList.remove(item);
                    break;
                case "Insert":
                    //Insert {number} {index}: insert a number at a given index
                    item = Integer.parseInt(commandLine.get(1));
                    int index = Integer.parseInt(commandLine.get(2));
                    numList.add(index, item);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(numList.toString()
                .replaceAll("[\\[\\],]", ""));
    }
}

