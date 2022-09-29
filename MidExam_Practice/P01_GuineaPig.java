package MidExam_Practice;

import java.util.Scanner;

public class P01_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double hayQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double coverQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double guineaWeight = Double.parseDouble(scanner.nextLine()) * 1000;
        boolean isRunOutOfSmth = false;

        for (int day = 1; day <= 30; day++) {
            //Every day Puppy eats 300 gr of food
            if (foodQuantity < 300) {
                isRunOutOfSmth = true;
                break;
            }
            foodQuantity -= 300;

            //Every second day Merry gives it a certain amount of hay
            // equal to 5% of the rest of the food
            if (day % 2 == 0) {
                double hayNeeded = foodQuantity * 0.05;
                if (hayNeeded > hayQuantity) {
                    isRunOutOfSmth = true;
                }
                hayQuantity -= hayNeeded;
            }
            if (isRunOutOfSmth) {
                break;
            }

            //every third day, Merry puts Puppy cover with
            // a quantity of 1/3 of its weight
            if (day % 3 == 0) {
                double coverNeeded = guineaWeight / 3;
                if (coverQuantity < coverNeeded) {
                    isRunOutOfSmth = true;
                }
                coverQuantity -= coverNeeded;
            }
            if (isRunOutOfSmth) {
                break;
            }

        }

        if (isRunOutOfSmth) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f."
                    , foodQuantity/1000, hayQuantity/1000, coverQuantity/1000);
        }
    }
}
