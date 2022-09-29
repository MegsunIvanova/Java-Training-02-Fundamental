package theme05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            String command = commandLine.get(0);
            int element = Integer.parseInt(commandLine.get(1));

            switch (command) {
                case "Delete":
                    //delete all elements in the array,
                    // which are equal to the given element
                    numList.removeIf(e -> e == element);
//                    numList.removeAll(Arrays.asList(element)); Същото като предното
                    break;
                case "Insert":
                    //insert element at the given position
                    int position = Integer.parseInt(commandLine.get(2));
                    numList.add(position, element);
                    break;
            }


            input = scanner.nextLine();
        }

        System.out.println(numList.toString()
                .replaceAll("[\\[\\],]", ""));
    }
}
