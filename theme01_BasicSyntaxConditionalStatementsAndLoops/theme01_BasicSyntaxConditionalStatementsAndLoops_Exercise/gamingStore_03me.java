package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class gamingStore_03me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();
        double price = 0.00;
        double totalSpend = 0;

        while (!game.equals("Game Time")) {
            boolean isNotFound = false;
            switch (game) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    isNotFound = true;
            }
            if (price == currentBalance) {
                currentBalance = 0;
                totalSpend += price;
                System.out.println("Bought " + game);
                System.out.println("Out of money!");
                break;
            }
            if (isNotFound) {
                System.out.println("Not Found");
            } else if (price > currentBalance) {
                System.out.println("Too Expensive");
            } else {
                currentBalance -= price;
                totalSpend += price;
                System.out.println("Bought " + game);
            }

            game = scanner.nextLine();
        }
        if (currentBalance > 0) {
            System.out.printf("Total spent: $%.2f. ", totalSpend);
            System.out.printf("Remaining: $%.2f", currentBalance);
        }
    }
}
