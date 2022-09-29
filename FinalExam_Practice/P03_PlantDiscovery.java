package FinalExam_Practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> plants = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);
            plants.put(plant, new int[]{rarity, 0, 0});
        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String command = input.split("[: \\-]+")[0];
            String plant = input.split("[: \\-]+")[1];
            if (command.equals("Rate")) {
                int rating = Integer.parseInt(input.split("[: \\-]+")[2]);
                //add the given rating to the plant (store all ratings)
                if (isValidPlant(plant, plants)) {
                    plants.get(plant)[1] += rating;
                    plants.get(plant)[2]++;
                }
            } else if (command.equals("Update")) {
                int newRarity = Integer.parseInt(input.split("[: \\-]+")[2]);
                if (isValidPlant(plant, plants)) {
                    plants.get(plant)[0] = newRarity;
                }
            } else if (command.equals("Reset")) {
                if (isValidPlant(plant, plants)) {
                    plants.get(plant)[1] = 0;
                    plants.get(plant)[2] = 0;
                }
            }

            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet().forEach(plant -> {
            double averageRating = 0;
            if (plant.getValue()[2] > 0) {
                averageRating = plant.getValue()[1]*1.0 / plant.getValue()[2];
            }
            System.out.printf("- %s; Rarity: %d; Rating: %.2f\n", plant.getKey(), plant.getValue()[0], averageRating);
        });

    }

    private static boolean isValidPlant(String plant, Map<String, int[]> plants) {
        if (plants.containsKey(plant)) {
            return true;
        } else {
            System.out.println("error");
            return false;
        }
    }
}
