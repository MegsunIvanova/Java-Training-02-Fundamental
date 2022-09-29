package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class E02_SpaceTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] routeToTitan = scanner.nextLine().split("\\|\\|");
        int fuel = Integer.parseInt(scanner.nextLine());
        int maxFuel = fuel;
        int ammunition = Integer.parseInt(scanner.nextLine());
        int maxAmmunition = ammunition;
        boolean isFailed = false;

        int index = 0;


        while (!routeToTitan[index].equals("Titan")) {

            String[] commandLine = routeToTitan[index].split(" ");
            String command = commandLine[0];

            if ("Travel".equals(command)) {
                int lightYears = Integer.parseInt(commandLine[1]);
                fuel -= lightYears;
                if (fuel >= 0) {
                    System.out.printf("The spaceship travelled %d light-years.\n", lightYears);
                } else {
                    System.out.println("Mission failed.");
                    isFailed = true;
                }

            } else if ("Enemy".equals(command)) {
                int enemyArmor = Integer.parseInt(commandLine[1]);

                //if ammunition is enough
                if (ammunition >= enemyArmor) {
                    ammunition -= enemyArmor;
                    System.out.printf("An enemy with %d armour is defeated.\n", enemyArmor);

                    //if ammunition isn't enough
                } else {
                    //if fuel is enough we try to run
                    if (enemyArmor * 2 <= fuel) {
                        fuel -= enemyArmor * 2;
                        System.out.printf("An enemy with %d armour is outmaneuvered.\n", enemyArmor);
                    } else {
                        System.out.println("Mission failed.");
                        isFailed = true;
                    }
                }

            } else if ("Repair".equals(command)) {
                int numberOfAddedItems = Integer.parseInt(commandLine[1]);

//                int addedFuel = 0;
//                if (fuel + numberOfAddedItems > maxFuel) {
//                    addedFuel = maxFuel - fuel;
//                } else {
//                    addedFuel = numberOfAddedItems;
//                }
//                fuel += addedFuel;
//
//                int addedAmmunition = 0;
//                if (ammunition + numberOfAddedItems * 2 > maxAmmunition) {
//                    addedAmmunition = maxAmmunition - ammunition;
//                } else {
//                    addedAmmunition = numberOfAddedItems * 2;
//                }
//                ammunition += addedAmmunition;
                    fuel += numberOfAddedItems;
                    ammunition += numberOfAddedItems*2;

                System.out.printf("Ammunitions added: %d.\n", numberOfAddedItems*2);
                System.out.printf("Fuel added: %d.\n", numberOfAddedItems);

            }

            if (isFailed) {
                break;
            }

            index++;
        }

        if (!isFailed) {
            System.out.println("You have reached Titan, all passengers are safe.");
        }

    }
}
