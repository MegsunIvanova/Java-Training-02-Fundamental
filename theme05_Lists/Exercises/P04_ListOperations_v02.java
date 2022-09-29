package theme05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListOperations_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            if (command.contains("Add")) {
                //•	Add {number} - add number at the end
                int numberToAdd = Integer.parseInt(command.split(" ")[1]);
                numbers.add(numberToAdd);//Винаги добавя елемента на края на списъка
            } else if (command.contains("Insert")) {
                //•	Insert {number} {index} - insert number at given index
                int numberToInsert = Integer.parseInt(command.split(" ")[1]);
                int index = Integer.parseInt(command.split(" ")[2]);
                if (isIndexValid(index, numbers.size())) {
                    numbers.add(index, numberToInsert);
                } else {
                    System.out.println("Invalid index");
                }


            } else if (command.contains("Remove")) {
                //•	Remove {index} - remove that index
                int indexToRemove = Integer.parseInt(command.split(" ")[1]);

                if (isIndexValid(indexToRemove, numbers.size())) {
                    numbers.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift left")) {
                //•	Shift left {count} - first number becomes last 'count' times
                int countLeft = Integer.parseInt(command.split(" ")[2]);
                for (int i = 1; i <= countLeft; i++) {
                    int firstNumber = numbers.get(0);
                    numbers.add(firstNumber);
                    numbers.remove(0);
                }
            } else if (command.contains("Shift right")) {
                //•	Shift right {count} - last number becomes first 'count' times
                int countRight = Integer.parseInt(command.split(" ")[2]);
                for (int i = 1; i <= countRight; i++) {
                    int lastNumber = numbers.get(numbers.size() - 1);
                    numbers.add(0, lastNumber);
                    numbers.remove(numbers.size() - 1);
                }

            }

            command = scanner.nextLine();
        }

        System.out.println(numbers.toString()
                        .

                replaceAll("[\\[\\],]", ""));

    }

    //метод, който валидира индекса
    private static boolean isIndexValid(int index, int sizeOfList) {
        return index >= 0 && index < sizeOfList;
    }
}
