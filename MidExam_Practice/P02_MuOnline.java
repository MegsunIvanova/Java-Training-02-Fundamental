package MidExam_Practice;

import java.util.Scanner;

public class P02_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;

        String[] dungeon = scanner.nextLine().split("\\|");

        for (int room = 0; room < dungeon.length; room++) {

            String[] command = dungeon[room].split(" ");
            switch (command[0]) {
                case "potion":
                    int potionQuantity = Integer.parseInt(command[1]);
                    int healAmount = getNewHealth(health, potionQuantity)[0];
                    health = getNewHealth(health, potionQuantity)[1];
                    System.out.printf("You healed for %d hp.\n", healAmount);
                    System.out.printf("Current health: %d hp.\n", health);
                    break;
                case "chest":
                    int amount = Integer.parseInt(command[1]);
                    bitcoins += amount;
                    System.out.printf("You found %d bitcoins.\n", amount);
                    break;
                default:
                    //In any other case, you are facing a monster
                    String monster = command[0];
                    int monsterAttack = Integer.parseInt(command[1]);
                    health -= monsterAttack;
                    printResultOfFacingMonster(health, monster, room);
                    break;
            }
            if (health <= 0) {
                break;
            }

        }
        if (health > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d\n", bitcoins);
            System.out.printf("Health: %d", health);
        }
    }

    private static int[] getNewHealth(int currentHealth, int potionQuantity) {
        //You are healed with the number in the second part.
        // But your health cannot exceed your initial health (100).
        int healAmount = potionQuantity;
        if (currentHealth + potionQuantity > 100) {
            healAmount = 100 - currentHealth;
            currentHealth = 100;
        } else {
            currentHealth += potionQuantity;
        }
        return new int[]{healAmount, currentHealth};
    }

    private static void printResultOfFacingMonster
            (int healthAfterAttack, String monster, int room) {
        if (healthAfterAttack > 0) {
            System.out.printf("You slayed %s.\n", monster);
        } else {
            System.out.printf("You died! Killed by %s.\n", monster);
            System.out.printf("Best room: %d", room + 1);
        }
    }
}
