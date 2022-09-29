package theme07_AssociativeArrays.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resourcesMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            resourcesMap.putIfAbsent(input, 0);
            resourcesMap.put(input, resourcesMap.get(input) + quantity);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourcesMap.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }

    }
}
