package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();
        double totalPrice = 0.00;

        switch (groupType) {
            case "Students":
                switch (day) {
                    case "Friday":
                        totalPrice = people * 8.45;
                        break;
                    case "Saturday":
                        totalPrice = people * 9.80;
                        break;
                    case "Sunday":
                        totalPrice = people * 10.46;
                        break;
                }
                if (people >= 30) {
                    totalPrice *= 0.85;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        totalPrice = people * 10.90;
                        break;
                    case "Saturday":
                        totalPrice = people * 15.60;
                        break;
                    case "Sunday":
                        totalPrice = people * 16.00;
                        break;
                }
                if (people >= 100) {
                    totalPrice -= 10 * (totalPrice / people);
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        totalPrice = people * 15.00;
                        break;
                    case "Saturday":
                        totalPrice = people * 20.00;
                        break;
                    case "Sunday":
                        totalPrice = people * 22.50;
                        break;
                }
                if (people >= 10 && people <= 20) {
                    totalPrice *= 0.95;
                }
                break;
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}

