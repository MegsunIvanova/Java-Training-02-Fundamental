package FinalExam_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_DestinationMapper_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(inputLine);
        int travelPoints = 0;
        List<String> destinationList = new ArrayList<>();

        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinationList.add(destination);
            travelPoints += destination.length();
        }

        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinationList));
        System.out.println("Travel Points: " + travelPoints);

    }
}
