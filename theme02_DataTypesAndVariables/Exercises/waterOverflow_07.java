package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class waterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poursNum = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int totalQuantity = 0;
        boolean isOverflow = false;

        for (int i = 1; i <= poursNum; i++) {
            int currentQuantity = Integer.parseInt(scanner.nextLine());

            if (totalQuantity + currentQuantity <= capacity) {
                totalQuantity += currentQuantity;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(totalQuantity);

    }
}
