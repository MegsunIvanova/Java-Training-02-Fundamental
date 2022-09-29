package theme09_RegularExpressions.Exersices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> furniture = new ArrayList<>();
        double totalMoney = 0;

        while (!input.equals("Purchase")) {
            //valid line:
            //">>{furniture name}<<{price}!{quantity}"
            Pattern pattern = Pattern.compile
                    ("^>>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+[.,]?[0-9]*)!(?<quantity>\\d+)\\b");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                furniture.add(matcher.group("furniture"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalMoney += price * quantity;
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        if (!furniture.isEmpty()) {
            System.out.println(String.join("\n", furniture));
        }
        System.out.printf("Total money spend: %.2f", totalMoney);

    }
}
