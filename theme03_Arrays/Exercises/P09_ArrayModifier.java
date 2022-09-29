package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P09_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandParts = input.split(" ");
            String commandType = commandParts[0];

            switch (commandType) {
                case "swap":
                    int index1 = Integer.parseInt(commandParts[1]);
                    int element1 = numArr[index1];
                    int index2 = Integer.parseInt(commandParts[2]);
                    int element2 = numArr[index2];

                    numArr[index1] = element2;
                    numArr[index2] = element1;
                    break;
                case "multiply":
                    int multiplyElementIndex1 = Integer.parseInt(commandParts[1]);
                    int multiplyElementIndex2 = Integer.parseInt(commandParts[2]);

                    int product = numArr[multiplyElementIndex1] * numArr[multiplyElementIndex2];
                    numArr[multiplyElementIndex1] = product;
                    break;
                case "decrease":
                    for (int i = 0; i < numArr.length; i++) {
                        numArr[i]--;
                    }
                    break;
            }

            input = scanner.nextLine();
        }

//        for (int i = 0; i < numArr.length; i++) {
//
//            if (i != numArr.length - 1) {
//                System.out.print(numArr[i] + ", ");
//            } else {
//                System.out.print(numArr[i]);
//            }
//        }
        System.out.println(Arrays.toString(numArr)
                .replace("[", "").replace("]", ""));
    }
}
