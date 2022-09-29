package theme06_BitwiseOperations.Lab;

import java.util.Scanner;
import java.util.stream.IntStream;

public class P01_BinaryDigitsCount {
    public static void main(String[] args) {
        //You are given a positive integer number and one binary digit B (0 or 1).
        // Your task is to write a program that finds the number
        // of binary digits (B) in a given integer.

        //1.	Declare two variables (n and b).
        //2.	Read the user input from the console.
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char b = scanner.nextLine().charAt(0);

        //3.	Convert the n into binary representation
        // (you can use the built-in method).

        //Decimal to binary
        //Вариант 1:
        String bin = Integer.toBinaryString(n);
        System.out.println(n + " -> " + bin);

        //Вариант 2:
        String bin2 = "";
        int currentNum = n;
        while (currentNum != 0) {
            int lastDigit = currentNum % 2;
            bin2 =lastDigit+bin2;
            currentNum /= 2;

        }
        System.out.println(n + " -> " + bin2);

        //4.	Count the b digit in the binary number.
        long count = bin.chars().filter(symbol -> symbol == b).count();
        long count2 = bin2.chars().filter(symbol -> symbol == b).count();

        //5.	Print the result on the console.
        System.out.println(count);
        System.out.println(count2);

    }

}
