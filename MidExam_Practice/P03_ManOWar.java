package MidExam_Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxHealth = Integer.parseInt(scanner.nextLine());
        boolean isDefeated = false;

        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Fire":
                    //•	"Fire {index} {damage}"
                    //the pirate ship attacks the warship
                    int attackIndex = Integer.parseInt(tokens[1]);
                    int damagePirateShip = Integer.parseInt(tokens[2]);
                    //attack warship and check if it was defeated
                    isDefeated = isWarshipDefeatedAfterAttack
                            (warShip, attackIndex, damagePirateShip);

                    break;
                case "Defend":
                    //•	"Defend {startIndex} {endIndex} {damage}"
                    //indexes from input are inclusive
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]) + 1;
                    int damageWarShip = Integer.parseInt(tokens[3]);
                    isDefeated = isPirateShipDefeatedAfterAttack
                            (pirateShip, startIndex, endIndex, damageWarShip);

                    break;
                case "Repair":
                    //•	"Repair {index} {health}"
                    int indexOfSection = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    repairPirateShipSection
                            (pirateShip, indexOfSection, health, maxHealth);

                    break;
                case "Status":
                    //prints the count of all sections of the pirate ship that
                    //are lower than 20% of the maximum health capacity
                    printStatus(pirateShip, maxHealth);
                    break;
            }
            if (isDefeated) {
                break;
            }
            input = scanner.nextLine();
        }

        if (!isDefeated) {
            int pirateShipStatus = 0;
            for (Integer sectionHealth : pirateShip) {
                pirateShipStatus += sectionHealth;
            }
            int warShipStatus = 0;
            for (Integer sectionHealth : warShip) {
                warShipStatus += sectionHealth;
            }

            System.out.println("Pirate ship status: " + pirateShipStatus);
            System.out.println("Warship status: " + warShipStatus);
        }
//        System.out.println(pirateShip);
//        System.out.println(warShip);

    }

    private static boolean isWarshipDefeatedAfterAttack(List<Integer> warShip
            , int index, int damage) {
        boolean isDefeated = false;
        //index validation
        if (index >= 0 && index < warShip.size()) {
            int sectionHealthAfterAttack = warShip.get(index) - damage;
            if (sectionHealthAfterAttack > 0) {
                warShip.set(index, sectionHealthAfterAttack);
            } else {
                System.out.println("You won! The enemy ship has sunken.");
                isDefeated = true;
            }
        }
        return isDefeated;
    }

    private static boolean isPirateShipDefeatedAfterAttack(List<Integer> pirateShip
            , int startIndex, int endIndex, int damage) {
        boolean isDefeated = false;
        //index validation
        if (startIndex >= 0 && endIndex <= pirateShip.size() && endIndex > startIndex) {
            for (int index = startIndex; index < endIndex; index++) {
                int sectionHealthAfterAttack = pirateShip.get(index) - damage;
                if (sectionHealthAfterAttack > 0) {
                    pirateShip.set(index, sectionHealthAfterAttack);
                } else {
                    System.out.println("You lost! The pirate ship has sunken.");
                    isDefeated = true;
                    break;
                }
            }
        }
        return isDefeated;
    }

    private static void repairPirateShipSection(List<Integer> pirateShip
            , int index, int health, int maxHealth) {
        //index validation
        if (index >= 0 && index < pirateShip.size()) {
            int sectionHealthAfterRepair = pirateShip.get(index) + health;
            if (sectionHealthAfterRepair > maxHealth) {
                pirateShip.set(index, maxHealth);
            } else {
                pirateShip.set(index, sectionHealthAfterRepair);
            }

        }
    }

    private static void printStatus(List<Integer> pirateShip, int maxHealth) {
        //index validation
        double minHealth = maxHealth * 0.20;
        int counter = 0;
        for (Integer sectionHealth : pirateShip) {
            if (sectionHealth < minHealth) {
                counter++;
            }
        }
        System.out.println(counter + " sections need repair.");
    }

}
