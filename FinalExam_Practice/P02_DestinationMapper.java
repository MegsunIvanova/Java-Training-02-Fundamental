package FinalExam_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([=\\/])(?<destination>[A-Z][A-Za-z]{2,})(?:\\1)");
        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinations.add(destination);
        }

        for (String destination : destinations) {
            travelPoints += destination.length();
        }

        System.out.print("Destinations: ");
        System.out.print(String.join(", ", destinations));
        System.out.println();

        System.out.println("Travel Points: "+travelPoints);

    }
}
