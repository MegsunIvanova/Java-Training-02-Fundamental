package theme06_BitwiseOperations.Lab;

import java.util.Scanner;

public class P06_TriBitSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that inverts the 3 bits from position p
        // to the left with their XOR opposites (e.g., 111 -> 000, 101 -> 010)
        // in a 32-bit number. Print the resulting integer on the console.

        //input
        //1234
        //7
        //00000000000000000000010011010010 
        //00000000000000000000011101010010
        int number = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());
        //1.Shift the number 7 (the number 7 has the bits 111,
        // which we use to get 3 consecutive values),
        // p times to the left (where p is the position) b
        // y using the << operator.
        // In that way, the 3 bits we want to invert will be at position p.
        // Save the resulting value in the mask.
        int mask = 7 << p; //mask = 1110000000

        //2. Use the ^ mask operator expression to invert
        // the values of the three bits starting from position p.
        // By using the following formulae (n ^ mask),
        // you copy all the bits of the number,
        // and you invert the bits at position p, p+1, and p+2.
        int newNumber = number^mask;
        System.out.println(newNumber);
        //  System.out.println(Integer.toBinaryString(newNumber));
    }
}
