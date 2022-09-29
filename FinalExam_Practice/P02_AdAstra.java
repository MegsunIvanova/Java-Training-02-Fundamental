package FinalExam_Practice;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //#{item name}#{expiration date}#{calories}#   or
        //|{item name}|{expiration date}|{calories}|
        String input = scanner.nextLine();
        //•	The item name will contain only lowercase and uppercase letters and whitespace
        //•	The expiration date will always follow the pattern: "{day}/{month}/{year}"
        //where the day, month, and year will be exactly two digits long
        //•	The calories will be an integer between 0-10000

        Pattern pattern = Pattern.compile("([#|])(?<food>[A-Za-z\\s]+)(?:\\1)(?<date>(?<day>[0-9]{2})/(?<month>[0-9]{2})/(?<year>[0-9]{2}))(?:\\1)(?<nutrition>[0-9]{1,5})(?:\\1)");
        Matcher matcher = pattern.matcher(input);
        List <String> food = new ArrayList<>();
        List <String> expirationDates = new ArrayList<>();
        List <Integer> nutritions = new ArrayList<>();

        while (matcher.find()) {
            String itemName = matcher.group("food");
            int day = Integer.parseInt(matcher.group("day"));
            int month = Integer.parseInt(matcher.group("month"));
            int year = Integer.parseInt(matcher.group("year"));
            String expirationDate = matcher.group("date");
            int nutrition = Integer.parseInt(matcher.group("nutrition"));
            if (nutrition >= 0 && nutrition <= 10000 && isValidDate(day, month, year)) {
               food.add(itemName);
               expirationDates.add(expirationDate);
               nutritions.add(nutrition);

            }
        }

        int totalNutrition = nutritions.stream().mapToInt(d -> d).sum();
        //you need 2000kcal a day
        int totalDays = totalNutrition / 2000;
        System.out.printf("You have food to last you for: %d days!\n", totalDays);
        for (int i = 0; i < food.size() ; i++) {
            String itemName = food.get(i);
            String expirationDate = expirationDates.get(i);
            int nutrition = nutritions.get(i);
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d\n",
                    itemName, expirationDate, nutrition);
        }

    }

    private static boolean isValidDate(int day, int month, int year) {
        year += 2000;
        LocalDate date;
        LocalDate today = LocalDate.of(2020, 8, 15);
        try {
            date = LocalDate.of(year, month, day);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
