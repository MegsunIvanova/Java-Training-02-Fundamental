package MidExam_Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Input: inventory with some collecting items, separated with a comma and a space (", ")
        List<String> inventory = Arrays.stream(scanner.nextLine()
                .split(", ")).collect(Collectors.toList());

        //Input: different commands split by " - "
        //until receiving "Craft!"

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String item = tokens[1];
            switch (command) {
                case "Collect":
                    //•	"Collect - {item}"
                    addItemToJournal(inventory, item);
                    break;

                case "Drop":
                    //•	"Drop - {item}"
                    dropItem(inventory, item);
                    break;

                case "Combine Items":
                    //•	"Combine Items - {old_item}:{new_item}"
                    String[] items = tokens[1].split(":");
                    String oldItem = items[0];
                    String newItem = items[1];
                    combineItems(inventory, oldItem, newItem);
                    break;

                case "Renew":
                    //•	"Renew – {item}"
                    renewItem(inventory, item);
                    break;
            }


            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", inventory));

    }


    private static boolean isExists(List<String> journal, String item) {
        return journal.contains(item);
    }

    private static void addItemToJournal(List<String> journal, String item) {
        // - you should add the given item to your inventory.
        // If the item already exists, you should skip this line.
        boolean isExists = isExists(journal, item);
        if (!isExists) {
            journal.add(item);
        }
    }

    private static void dropItem(List<String> journal, String item) {
        // - you should remove the item from your inventory if it exists.
        boolean isExists = isExists(journal, item);
        if (isExists) {
            journal.remove(item);
        }
    }

    private static void combineItems(List<String> journal, String oldItem, String newItem) {
        // - you should check if the old item exists.
        // If so, add the new item after the old one.
        // Otherwise, ignore the command.
        boolean isOldItemExists = isExists(journal, oldItem);
        if (isOldItemExists) {
            int index = journal.indexOf(oldItem) + 1;

            journal.add(index, newItem);

        }
    }

    private static void renewItem(List<String> journal, String item) {
        /// – if the given item exists,
        // you should change its position and
        // put it last in your inventory.
        boolean isExists = isExists(journal, item);
        if (isExists) {
            journal.remove(item);
            journal.add(item);
        }
    }

}
