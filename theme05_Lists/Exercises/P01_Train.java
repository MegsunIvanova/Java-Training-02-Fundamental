package theme05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxWagonSCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            List<String> instructions = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());

            if (instructions.size() > 1) {
                //•	Add {passengers} - add a wagon to the end with the given number of passengers
                int newWagonWithPassengers = Integer.parseInt(instructions.get(1));
                int indexNewWagon = wagons.size();
                wagons.add(indexNewWagon, newWagonWithPassengers);
            } else {
                //•	{passengers} -  find an existing wagon to fit all the passengers (starting from the first wagon)
                int passengers = Integer.parseInt(instructions.get(0));
                for (int i = 0; i < wagons.size(); i++) {

                    int freeCapacity = maxWagonSCapacity - wagons.get(i);
                    if (freeCapacity >= passengers) {
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }

        System.out.println(wagons.toString()
                .replaceAll("[\\[\\],]", ""));
    }
}
