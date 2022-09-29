package theme07_AssociativeArrays.Exercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P05_DragonArmy_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, Integer[]>> dragonsMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            //"{type} {name} {damage} {health} {armor}"
            String type = input.split(" ")[0];
            String name = input.split(" ")[1];
            dragonsMap.putIfAbsent(type, new TreeMap<>());

            Integer damage = getStatFromInput(input.split(" ")[2]);
            if (damage == null) {
                damage = 45;
            }
            Integer health = getStatFromInput(input.split(" ")[3]);
            if (health == null) {
                health = 250;
            }
            Integer armor = getStatFromInput(input.split(" ")[4]);
            if (armor == null) {
                armor = 10;
            }
            dragonsMap.get(type).put(name, new Integer[]{damage, health, armor});
        }

        dragonsMap.entrySet().stream().forEach(entry -> {
            double averageDamage = getAverageByDragonTypeAndStatIndex(entry.getKey(), 0, dragonsMap);
            double averageHealth = getAverageByDragonTypeAndStatIndex(entry.getKey(), 1, dragonsMap);
            double averageArmor = getAverageByDragonTypeAndStatIndex(entry.getKey(), 2, dragonsMap);
            char forwardSlash = '/';
            System.out.printf("%s::(%.2f%c%.2f%c%.2f)\n", entry.getKey(), averageDamage, forwardSlash, averageHealth, forwardSlash, averageArmor);
            entry.getValue().entrySet().forEach(dragon -> {
                String name = dragon.getKey();
                int damage = dragon.getValue()[0];
                int health = dragon.getValue()[1];
                int armor = dragon.getValue()[2];
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", name, damage, health, armor);
            });
        });
    }

    private static Integer getStatFromInput(String inputValue) {
        if (inputValue.equals("null")) {
            return null;
        } else {
            return Integer.parseInt(inputValue);
        }
    }

    private static double getAverageByDragonTypeAndStatIndex
            (String dragonType, int statIndex,
             Map<String, TreeMap<String, Integer[]>> dragonsMap) {

        AtomicInteger statSum = new AtomicInteger(0);
        int statCount = dragonsMap.get(dragonType).entrySet().size();
        dragonsMap.get(dragonType).entrySet().stream().forEach(dragon -> {

            statSum.set(statSum.get() + dragon.getValue()[statIndex]);

        });

        return statSum.get() * 1.0 / statCount;
    }
}
