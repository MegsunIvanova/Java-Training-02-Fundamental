package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class spiceMustFlow_09_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int extractedSpice = 0;
        int days = 0;

        for (int source = startingYield; source >= 100; source -= 10) {
            days++;
            int spice = source - 26;
            extractedSpice += spice;
        }

        if (extractedSpice >= 26) {
            extractedSpice -= 26;
        }

        System.out.println(days);
        System.out.println(extractedSpice);
    }
}
