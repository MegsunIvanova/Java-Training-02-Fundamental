package theme05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Messaging_me {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<String> text = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        String message = "";
        for (int i = 0; i < numbers.size(); i++) {
            int sumOfDigits = 0;
            int currentNumber = numbers.get(i);

            while (currentNumber != 0) {
                sumOfDigits += currentNumber % 10;
                currentNumber /= 10;
            }
            if (sumOfDigits >= text.size()) {
                sumOfDigits = sumOfDigits % text.size();
            }
            message += text.get(sumOfDigits);
            text.remove(sumOfDigits);
        }
//        System.out.println(text);
        System.out.println(message);
    }
}
