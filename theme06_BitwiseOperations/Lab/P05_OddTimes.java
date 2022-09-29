package theme06_BitwiseOperations.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05_OddTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //You are given an array of positive integers in a single line,
        // separated by a space (' ').
        // All numbers occur an even number of times except one number,
        // which occurs an odd number of times.
        // Find it using only bitwise operations.

        //1.	Read an array of integers.
        int[] numbersArr = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        //2.	Initialize a variable result with a value of 0.
        int result = 0;

        //3.	Iterate through all numbers in the array.
        for (int i = 0; i < numbersArr.length; i++) {
            int firstNumber = numbersArr[i];
            int currentResult = 1;
            for (int j = 0; j < numbersArr.length; j++) {
                if (j == i) {
                    continue;
                }
                int secondNumber = numbersArr[j];
                if ((firstNumber ^ secondNumber) == 0) {
                    //4.	Use XOR (^) of the result and all numbers in the array.
                    //a.	XOR of two elements is 0 if both elements are the same,
                    // and XOR of a number x with 0 is x
                    currentResult++;
                }
            }
            if ((currentResult % 2 ^ 0) != 0) {
                result = firstNumber;
                break;
            }
        }
        System.out.println(result);
    }
}
