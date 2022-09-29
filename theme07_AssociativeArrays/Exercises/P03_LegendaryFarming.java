package theme07_AssociativeArrays.Exercises;

import java.util.*;

public class P03_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //the key materials	(case-insensitive):
        //•	"Shadowmourne" - requires 250 Shards
        //•	"Valanyr" - requires 250 Fragments
        //•	"Dragonwrath" - requires 250 Motes

        //everything else is junk
        //key materials - the first one that reaches 250, wins the race
        Map<String, String> legendaryItemsMap = new LinkedHashMap<>();
        legendaryItemsMap.put("shards", "Shadowmourne");
        legendaryItemsMap.put("fragments", "Valanyr");
        legendaryItemsMap.put("motes", "Dragonwrath");

        Map<String, Integer> keyMaterialsMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : legendaryItemsMap.entrySet()) {
            keyMaterialsMap.put(entry.getKey(), 0);
        }
        Map<String, Integer> junkMaterialsMap = new LinkedHashMap<>();
        boolean isLegendaryItemObtained = false;

        while (!isLegendaryItemObtained) {
            String[] inputLine = scanner.nextLine().split(" ");
            for (int i = 0; i < inputLine.length - 1; i += 2) {
                String material = inputLine[i + 1].toLowerCase();
                int collectedQuantity = Integer.parseInt(inputLine[i]);
                switch (material) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        getKeyMaterial(keyMaterialsMap, material, collectedQuantity);
                        break;
                    default:
                        getJunkMaterial(junkMaterialsMap, material, collectedQuantity);
                        break;
                }
                isLegendaryItemObtained = isLegendaryItemObtained(keyMaterialsMap);
                if (isLegendaryItemObtained) {
                    String obtainedMaterial = getObtainedMaterial(keyMaterialsMap);
                    String obtainedItem = legendaryItemsMap.get(obtainedMaterial);
                    System.out.println(obtainedItem + " obtained!");
                    keyMaterialsMap.put(obtainedMaterial, keyMaterialsMap.get(obtainedMaterial) - 250);
                    break;
                }
            }
        }

        printMap(keyMaterialsMap);
        printMap(junkMaterialsMap);


    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }

    }

    private static boolean isLegendaryItemObtained(Map<String, Integer> materialsMap) {
        for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
            if (entry.getValue() >= 250) {
                return true;
            }
        }
        return false;
    }

    private static String getObtainedMaterial(Map<String, Integer> materialsMap) {
        for (Map.Entry<String, Integer> entry : materialsMap.entrySet()) {
            if (entry.getValue() >= 250) {
                return entry.getKey();
            }
        }
        return "";
    }

    public static void getKeyMaterial(Map<String, Integer> materialsMap
            , String material, int collectedQuantity) {
        int newKeyQuantity = materialsMap.get(material) + collectedQuantity;
        materialsMap.put(material, newKeyQuantity);

    }

    public static void getJunkMaterial(Map<String, Integer> materialsMap
            , String material, int collectedQuantity) {
        materialsMap.putIfAbsent(material, 0);
        int newKeyQuantity = materialsMap.get(material) + collectedQuantity;
        materialsMap.put(material, newKeyQuantity);

    }

}
