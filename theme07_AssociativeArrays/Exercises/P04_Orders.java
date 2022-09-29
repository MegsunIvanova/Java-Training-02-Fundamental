package theme07_AssociativeArrays.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productPricesMap = new LinkedHashMap<>();
        Map<String, Integer> productQuantityMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);
            //If you receive a product, which already exists,
            // increases its quantity by the input quantity and
            // if its price is different, replace the price as well.
            productPricesMap.put(product, price);
            productQuantityMap.putIfAbsent(product, 0);
            int newQuantity = productQuantityMap.get(product) + quantity;
            productQuantityMap.put(product, newQuantity);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productPricesMap.entrySet()) {
            String product = entry.getKey();
            double totalPrice = entry.getValue() * productQuantityMap.get(product);
            System.out.printf("%s -> %.2f\n", product, totalPrice);
        }

    }
}
