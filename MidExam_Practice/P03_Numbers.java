package MidExam_Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        //finding the average value
        double sumOfNumbers = 0.0;
        for (Integer number : numbers) {
            sumOfNumbers += number;
        }
        double averageValue = sumOfNumbers / numbers.size();

        //remove all numbers that are not greater than the averageValue
        numbers.removeIf(e -> e <= averageValue);

        //sort List in ascending order
        Collections.sort(numbers);
        //reverse List to become in descending order
        Collections.reverse(numbers);
        //remove last elements so that numbers.size() == 5
        if (numbers.size() > 5) {
            numbers.removeAll(numbers.subList(5, numbers.size()));
        }

        //printing
        if (numbers.size() > 0) {
            System.out.println(numbers.toString()
                    .replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println("No");
        }


    }
}
