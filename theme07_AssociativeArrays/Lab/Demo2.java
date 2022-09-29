package theme07_AssociativeArrays.Lab;

import java.util.LinkedHashMap;
import java.util.Map;

public class Demo2 {
    public static void main(String[] args) {
        Map<String, Double> fruits = new LinkedHashMap<>();
        fruits.put("banana", 2.20);
        fruits.put("kiwi", 4.50);
        for (Map.Entry<String, Double> entry : fruits.entrySet()) {
            System.out.printf("%s -> %.2f%n",
                    entry.getKey(), entry.getValue());
        }

    }
}
