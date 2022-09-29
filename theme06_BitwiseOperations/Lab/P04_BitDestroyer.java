package theme06_BitwiseOperations.Lab;

import java.util.Scanner;

public class P04_BitDestroyer {
    public static void main(String[] args) {
        //Write a program that sets the bit at position p to 0.
        // Print the resulting integer.
        Scanner scanner = new Scanner (System.in);
        //input
        //number = 1313 -> 10100100001
        //position = 5
        int number = Integer.parseInt(scanner.nextLine());
        //System.out.println(Integer.toBinaryString(number)+" number");
        int position = Integer.parseInt(scanner.nextLine());
        //1) Shift the number 1, p times to the left (where p is the position)
        // by using the << operator.
        // In that way, the bit we want to delete will be at position p
        int mask = 1 << position; //mask = 100000
        // System.out.println(Integer.toBinaryString(mask)+" mask = shifted 1 p-times");
        //2) Invert the mask
        // (e.g., we move the number 1, 3 times,
        // and we get 00001000, after inverting, we get 11110111).
        mask = ~mask; //mask = 11111111111111111111111111011111
        // System.out.println(Integer.toBinaryString(mask)+" inverted mask");
        //3) Use & mask operator expression to set the value of a number to 0.
        // By using the following formulae (n & mask),
        // you copy all the bits of the number, and you set the bit at position p to 0;
        int newNumber = number & mask; //newNumber = 10100000001 = 1281
        // System.out.println(Integer.toBinaryString(newNumber)+" result number plus mask");
        // System.out.println("RESULT:");
        System.out.println(newNumber);
    }
}
