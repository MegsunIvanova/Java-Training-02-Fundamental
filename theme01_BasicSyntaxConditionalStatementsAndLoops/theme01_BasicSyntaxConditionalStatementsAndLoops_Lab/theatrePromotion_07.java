package tema01_BasicSyntaxConditionalStatementsAndLoops_Lab;

import java.util.Scanner;

public class theatrePromotion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayType = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;
        boolean isNotValid = false;

        if (age >= 0 && age <= 18) {
            if ("Weekday".equals(dayType)) {
                price = 12;
            } else if ("Weekend".equals(dayType)) {
                price = 15;
            } else if ("Holiday".equals(dayType)) {
                price = 5;
            }

        } else if (age > 18 && age <= 64) {
            if ("Weekday".equals(dayType)) {
                price = 18;
            } else if ("Weekend".equals(dayType)) {
                price = 20;
            } else if ("Holiday".equals(dayType)) {
                price = 12;
            }

        } else if (age > 64 && age <= 122) {
            if ("Weekday".equals(dayType)) {
                price = 12;
            } else if ("Weekend".equals(dayType)) {
                price = 15;
            } else if ("Holiday".equals(dayType)) {
                price = 10;
            }

        } else {
            isNotValid = true;

        }

        if (isNotValid) {
            System.out.println("Error!");
        } else {
            System.out.printf("%d$", price);
        }
    }
}
