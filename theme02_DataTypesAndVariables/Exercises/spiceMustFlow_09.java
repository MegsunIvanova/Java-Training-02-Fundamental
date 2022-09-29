package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class spiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int source = Integer.parseInt(scanner.nextLine());
        int extractedSpice = 0;
        int days = 0;

        while (source >= 100) {
            days++;
            int spice = source - 26;

            extractedSpice += spice;
            source -= 10;
        }
        if (extractedSpice >= 26) {
            extractedSpice -= 26;
        }

        System.out.println(days);
        System.out.println(extractedSpice);
    }
}
