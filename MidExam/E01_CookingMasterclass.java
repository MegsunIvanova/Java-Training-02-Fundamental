package MidExam;

import java.util.Scanner;

public class E01_CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double packageFlourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());

        int freeFlourPackages = students / 5;
        double flourTotalPrice = (students - freeFlourPackages) * packageFlourPrice;
        double eggsTotalPrice = students * 10 * eggPrice;
        double numberOfAprons = Math.ceil(students * 1.2);
        double apronsTotalPrice = numberOfAprons * apronPrice;

        double totalPrice = flourTotalPrice + eggsTotalPrice + apronsTotalPrice;

        if (totalPrice <= budget) {
            System.out.printf("Items purchased for %.2f$.", totalPrice);
        } else {
            System.out.printf("%.2f$ more needed.", totalPrice - budget);
        }
    }
}
