package MidExam_Practice;

import java.util.Scanner;

public class P01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalPriceWithoutTaxes = 0.0;

        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price > 0) {
                totalPriceWithoutTaxes += price;
            } else {
                System.out.println("Invalid price!");
            }
            input = scanner.nextLine();
        }
        double taxes = totalPriceWithoutTaxes * 0.2;
        double totalPrice = totalPriceWithoutTaxes + taxes;
        if (input.equals("special")) {
            totalPrice *= 0.90;
        }

        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", totalPriceWithoutTaxes);
            System.out.printf("Taxes: %.2f$\n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$\n", totalPrice);
        }
    }
}
