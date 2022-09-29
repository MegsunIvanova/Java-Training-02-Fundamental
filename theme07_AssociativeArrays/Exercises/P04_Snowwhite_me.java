package theme07_AssociativeArrays.Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_Snowwhite_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> dwarfsMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Once upon a time")) {
            //"{dwarfName} <:> {dwarfHatColor} <:> {dwarfPhysics}"
            String dwarfNameAndHatColor = input.split(" <:> ")[0]
                    + " : " + input.split(" <:> ")[1];
            int dwarfPhysics = Integer.parseInt(input.split(" <:> ")[2]);
            dwarfsMap.putIfAbsent(dwarfNameAndHatColor, 0);
            if (dwarfsMap.get(dwarfNameAndHatColor) < dwarfPhysics) {
                dwarfsMap.put(dwarfNameAndHatColor, dwarfPhysics);
            }

            input = scanner.nextLine();
        }
        Map<String, Integer> countHatsColor = new HashMap<>();
        dwarfsMap.entrySet().stream().forEach(dwarf -> {
            String hatColor = dwarf.getKey().split(" : ")[1];
            countHatsColor.putIfAbsent(hatColor, 0);
            countHatsColor.put(hatColor, countHatsColor.get(hatColor) + 1);
        });

        dwarfsMap.entrySet().stream().sorted((dwarf1, dwarf2) -> {
            int sortResult = (Integer.compare(dwarf1.getValue(), dwarf2.getValue())) * (-1);
            if (sortResult == 0) {
                String hatColorDwarf1 = dwarf1.getKey().split(" : ")[1];
                String hatColorDwarf2 = dwarf2.getKey().split(" : ")[1];
                sortResult = (Integer.compare(countHatsColor.get(hatColorDwarf1), countHatsColor.get(hatColorDwarf2))) * (-1);
            }
            return sortResult;
        }).forEach(dwarf -> {
            String dwarfName = dwarf.getKey().split(" : ")[0];
            String dwarfHatColor = dwarf.getKey().split(" : ")[1];
            System.out.printf("(%s) %s <-> %d\n", dwarfHatColor, dwarfName, dwarf.getValue());
        });

    }
}
