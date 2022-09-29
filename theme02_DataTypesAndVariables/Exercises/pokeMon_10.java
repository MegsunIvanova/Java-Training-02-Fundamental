package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class pokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int pokeCounter = 0;
        int startPower = power;

        while (power >= distance) {
            pokeCounter++;

            power -= distance;
            if (power == startPower * 0.5 && exhaustionFactor > 0) {
                power /= exhaustionFactor;
            }
        }
        System.out.println(power);
        System.out.println(pokeCounter);
    }
}
