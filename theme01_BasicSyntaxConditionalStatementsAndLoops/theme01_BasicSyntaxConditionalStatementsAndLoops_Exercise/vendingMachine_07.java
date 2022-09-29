package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class vendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0;

        while (!input.equals("Start")) {
            double currentMoney = Double.parseDouble(input);
            if (currentMoney == 0.10 || currentMoney == 0.20 || currentMoney == 0.50 || currentMoney == 1.00 || currentMoney == 2.00) {
                totalMoney += currentMoney;
            } else {
                System.out.printf("Cannot accept %.2f\n", currentMoney);
            }
            input = scanner.nextLine();
        }

        String product = scanner.nextLine();

        while (!product.equals("End")) {
            double price = 0;
            boolean isInvalid = false;

            switch (product) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    isInvalid = true;
            }
            if (isInvalid) {
                System.out.println("Invalid product");
            } else if (price <= totalMoney) {
                totalMoney -= price;
                System.out.printf("Purchased %s\n", product);
            } else {
                System.out.println("Sorry, not enough money");
            }

            product = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", totalMoney);
    }
}
