package theme03_Arrays.Lab;

import java.util.Scanner;

public class P01_DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        String[] weekday = new String[]{
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        if (number >= 1 && number <= 7) {
            System.out.println(weekday[number - 1]);
        } else {
            System.out.println("Invalid day!");
        }

    }
}
