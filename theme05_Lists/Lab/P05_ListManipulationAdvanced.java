package theme05_Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            String command = commandLine.get(0);
            String item = commandLine.get(1);
            switch (command) {
                case "Contains":
                    int number = Integer.parseInt(item);
                    printIfListContainsTheNumber(numList, number);
                    break;
                case "Print":
                    //Print even – print all the numbers that are even separated by a space
                    //Print odd – print all the numbers that are oddly separated by a space
                    printEvenOddElementsOfList(numList, item);
                    break;
                case "Get":
                    System.out.println(getSum(numList));
                    break;
                case "Filter":
                    String condition = item;
                    int num = Integer.parseInt(commandLine.get(2));
                    printFilteredList(numList, condition, num);
                    break;
            }


            input = scanner.nextLine();
        }
    }

    private static void printEvenOddElementsOfList(List<Integer> numList, String printNum) {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(numList);

        if (printNum.equals("even")) {
            newList.removeIf(e -> e % 2 != 0);
        } else if (printNum.equals("odd")) {
            newList.removeIf(e -> e % 2 == 0);
        }
        printList(newList);
    }

    private static void printList(List<Integer> numList) {

        System.out.println(numList.toString()
                .replaceAll("[\\[\\],]", ""));
    }

    private static int getSum(List<Integer> numList) {
        int sum = 0;
        for (Integer number : numList) {
            sum += number;
        }
        return sum;
    }

    private static void printIfListContainsTheNumber
            (List<Integer> numList, int number) {
        if (numList.contains(number)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    private static void printFilteredList
            (List<Integer> numList, String condition, int number) {

        List<Integer> filteredList = new ArrayList<>();
        filteredList.addAll(numList);

        switch (condition) {
            case "<":
                filteredList.removeIf(e -> e >= number);
                break;
            case ">":
                filteredList.removeIf(e -> e <= number);
                break;
            case ">=":
                filteredList.removeIf(e -> e < number);
                break;
            case "<=":
                filteredList.removeIf(e -> e > number);
                break;
        }

        printList(filteredList);
    }
}
