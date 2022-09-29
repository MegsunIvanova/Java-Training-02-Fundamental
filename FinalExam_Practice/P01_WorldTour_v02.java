package FinalExam_Practice;

import java.util.Scanner;

public class P01_WorldTour_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stops = scanner.nextLine(); //string containing all of your stops
        StringBuilder stopsBuilder = new StringBuilder(stops);

        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            //команда
            if (command.contains("Add Stop")) {
                //1. command = "Add Stop:{index}:{string}"
                int index = Integer.parseInt(command.split(":")[1]);
                String stopName = command.split(":")[2];
                //1. валидиране на индекс
                if (isValidIndex(index, stopsBuilder)) {
                    stopsBuilder.insert(index, stopName);
                }

            } else if (command.contains("Remove Stop")) {
                //2. command = "Remove Stop:{start_index}:{end_index}"
                //o	Remove the elements of the string
                // from the starting index to the end index (inclusive)
                // if both indices are valid
                int startIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);
                if (isValidIndex(startIndex, stopsBuilder) && isValidIndex(endIndex, stopsBuilder)) {
                    stopsBuilder.delete(startIndex, endIndex + 1);
                }

            } else if (command.contains("Switch")) {
                //3. command = "Switch:{old_string}:{new_string}"
                //•	•	"Switch:{old_string}:{new_string}"
                String oldText = command.split(":")[1];
                String newText = command.split(":")[2];
                //o	If the old string is in the initial string,
                // replace it with the new one (all occurrences)
                if (stops.contains(oldText)) {
                    String updatedText = stopsBuilder.toString().replace(oldText, newText);
                    stopsBuilder = new StringBuilder(updatedText);
                }
            }
            System.out.println(stopsBuilder);
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stopsBuilder);

    }

    private static boolean isValidIndex(int index, StringBuilder builder) {
        return index >= 0 && index <= builder.length() - 1;
    }

}
