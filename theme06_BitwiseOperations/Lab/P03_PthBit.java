package theme06_BitwiseOperations.Lab;

import java.util.Scanner;

public class P03_PthBit {
    public static void main(String[] args) {
        //Write a program that prints the bit at position p of the given integer.
        // We use the standard counting: from right to left, starting from 0.
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());
        int shiftedNumber = number >> position;
        int mask = 1;
        int bitAtPosition = shiftedNumber & mask;
        System.out.println(bitAtPosition);
    }
}
