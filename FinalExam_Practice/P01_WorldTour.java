package FinalExam_Practice;

import java.util.Scanner;

public class P01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder plannedStops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            if (input.contains("Add Stop")) {
                addStop(input, plannedStops);
            } else if (input.contains("Remove Stop")) {
                removeStop(input, plannedStops);
            } else if (input.contains("Switch")) {
                switchStop(input, plannedStops);
            }
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + plannedStops.toString());

    }

    private static void addStop(String input, StringBuilder plannedStops) {
        //•	"Add Stop:{index}:{string}"
        int index = Integer.parseInt(input.split(":")[1]);
        String stopToAdd = input.split(":")[2];
        //o	Insert the given string at that index only if the index is valid
        if (index >= 0 && index < plannedStops.length()) {
            plannedStops.insert(index, stopToAdd);
        }
        System.out.println(plannedStops.toString());

    }

    private static void removeStop(String input, StringBuilder plannedStops) {
        //•	"Remove Stop:{start_index}:{end_index}"
        int startIndex = Integer.parseInt(input.split(":")[1]);
        int endIndex = Integer.parseInt(input.split(":")[2]);
        //o	Remove the elements of the string
        // from the starting index to the end index (inclusive)
        // if both indices are valid
        if (startIndex >= 0 && endIndex >= startIndex && endIndex < plannedStops.length()) {
            plannedStops.delete(startIndex, endIndex + 1);
        }
        System.out.println(plannedStops.toString());


    }

    private static void switchStop(String input, StringBuilder plannedStops) {
        //•	•	"Switch:{old_string}:{new_string}"
        String oldString = input.split(":")[1];
        String newString = input.split(":")[2];
        //o	If the old string is in the initial string,
        // replace it with the new one (all occurrences)
        if (plannedStops.toString().contains(oldString)) {
            int index = plannedStops.indexOf(oldString);
            while (index != -1) {
                plannedStops.replace(index, index + oldString.length(), newString);
                index += newString.length(); // Move to the end of the replacement
                index = plannedStops.indexOf(oldString,index);
            }
        }
        System.out.println(plannedStops.toString());
    }
}
