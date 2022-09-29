package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class orders_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        double totalSum = 0;

        for (int i = 1; i <= num; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int daysInMonth = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            double orderPrice = ((daysInMonth * capsulesCount) * pricePerCapsule);
            totalSum += orderPrice;
            System.out.printf("The price for the coffee is: $%.2f\n", orderPrice);
        }

        System.out.printf("Total: $%.2f", totalSum);
    }
}
