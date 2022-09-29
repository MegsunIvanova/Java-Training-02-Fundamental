package MidExam_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] groceries = scanner.nextLine().split("!");

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            String[] commandInstructions = command.split(" ");
            String activity = commandInstructions[0];
            switch (activity) {
                case "Urgent":
                    String urgentItem = commandInstructions[1];
                    groceries = updateGroceriesAfterCommandUrgent(groceries, urgentItem);
                    break;
                case "Unnecessary":
                    String unnecessaryItem = commandInstructions[1];
                    groceries = updateGroceriesAfterCommandUnnecessary
                            (groceries, unnecessaryItem);
                    break;
                case "Correct":
                    String oldItem = commandInstructions[1];
                    String newItem = commandInstructions[2];
                    groceries = updateGroceriesAfterCorrection(groceries, oldItem, newItem);
                    break;
                case "Rearrange":
                    String rearrangeItem = commandInstructions[1];
                    groceries = updateGroceriesAfterRearrange(groceries, rearrangeItem);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(groceries)
                .replace("[", "").replace("]", ""));

    }

    private static String[] updateGroceriesAfterCommandUrgent
            (String[] groceries, String urgentItem) {
        //add the item at the start of the list.
        // If the item already exists, skip this command.
        boolean isExists = false;
        for (String currentGrocery : groceries) {
            if (currentGrocery.equals(urgentItem)) {
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            String[] updatedGroceries = new String[groceries.length + 1];
            updatedGroceries[0] = urgentItem;
            for (int i = 1; i < updatedGroceries.length; i++) {
                updatedGroceries[i] = groceries[i - 1];
            }
            groceries = updatedGroceries;
        }
        return groceries;
    }

    private static String[] updateGroceriesAfterCommandUnnecessary
            (String[] groceries, String unnecessaryItem) {
        //remove the item with the given name, only if it exists in the list.
        // Otherwise, skip this command.
        boolean isExists = false;
        for (String currentGrocery : groceries) {
            if (currentGrocery.equals(unnecessaryItem)) {
                isExists = true;
                break;
            }
        }
        if (isExists) {
            if (groceries.length > 1) {
                String[] updatedGroceries = new String[groceries.length - 1];
                int oldIndex = 0;
                for (int newIndex = 0; newIndex < updatedGroceries.length; newIndex++) {
                    if (groceries[oldIndex].equals(unnecessaryItem)) {
                        oldIndex++;
                    }
                    updatedGroceries[newIndex] = groceries[oldIndex];
                    oldIndex++;
                }
                groceries = updatedGroceries;
            } else {
                groceries = null;
            }
        }
        return groceries;
    }

    private static String[] updateGroceriesAfterCorrection
            (String[] groceries, String oldItem, String newItem) {
        //if the item with the given old name exists, change its name with the new one. 
        // Otherwise, skip this command.
        for (int i = 0; i < groceries.length; i++) {
            if (groceries[i].equals(oldItem)) {
                groceries[i] = newItem;
            }
        }

        return groceries;
    }

    private static String[] updateGroceriesAfterRearrange
            (String[] groceries, String rearrangeItem) {
        //if the grocery exists in the list,
        // remove it from its current position and add it at the end of the list.
        // Otherwise, skip this command.
        boolean isOldItemIndexFound = false;
        for (int i = 0; i < groceries.length; i++) {
            if (groceries[i].equals(rearrangeItem)) {
                isOldItemIndexFound = true;
            }
            if (isOldItemIndexFound) {
                if (i == groceries.length - 1) {
                    groceries[i] = rearrangeItem;
                } else {
                    groceries[i] = groceries[i + 1];
                }
            }

        }
        return groceries;
    }
}
