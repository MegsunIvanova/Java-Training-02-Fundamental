package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P10_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] treasureChess = scanner.nextLine().replace("|", " ").split(" ");
//        System.out.println(Arrays.deepToString(treasureChess));
        String command = scanner.nextLine();
        boolean isFailed = false;

        while (!command.equals("Yohoho!")) {
            String[] commandArr = command.split(" ");
            String action = commandArr[0];
            switch (action) {
                case "Loot":
                    for (int newItemIndex = 1; newItemIndex < commandArr.length; newItemIndex++) {
                        boolean isFound = false;
                        for (String treasure : treasureChess) {
                            if (treasure.equals(commandArr[newItemIndex])) {
                                isFound = true;
                                break;
                            }
                        }
                        if (!isFound) {
                            String[] oldTreasureChess = treasureChess;
                            treasureChess = new String[oldTreasureChess.length + 1];
                            treasureChess[0] = commandArr[newItemIndex];
                            for (int i = 1; i < treasureChess.length; i++) {
                                treasureChess[i] = oldTreasureChess[i - 1];
                            }
                        }
                    }
                    break;
                case "Drop":
                    int indexDroppedItem = Integer.parseInt(commandArr[1]);
                    if (indexDroppedItem >= 0 && indexDroppedItem < treasureChess.length) {
                        String droppedItem = treasureChess[indexDroppedItem];
                        for (int i = indexDroppedItem; i < treasureChess.length - 1; i++) {
                            treasureChess[i] = treasureChess[i + 1];
                        }
                        treasureChess[treasureChess.length - 1] = droppedItem;
                    }
                    break;
                case "Steal":
                    int numberStolenItems = Integer.parseInt(commandArr[1]);
                    if (numberStolenItems < treasureChess.length) {
                        String[] oldTreasureChess = treasureChess;
                        treasureChess = new String[oldTreasureChess.length - numberStolenItems];
                        for (int i = 0; i < treasureChess.length; i++) {
                            treasureChess[i] = oldTreasureChess[i];
                        }
                        for (int i = oldTreasureChess.length - numberStolenItems; i < oldTreasureChess.length; i++) {
                            if (i < oldTreasureChess.length - 1) {
                                System.out.print(oldTreasureChess[i] + ", ");
                            } else {
                                System.out.println(oldTreasureChess[i]);
                            }
                        }
                    } else {
                        for (int i = 0; i < treasureChess.length; i++) {
                            if (i < treasureChess.length - 1) {
                                System.out.print(treasureChess[i] + ", ");
                            } else {
                                System.out.println(treasureChess[i]);
                            }
                        }
                        isFailed = true;
                        System.out.println("Failed treasure hunt.");
                    }
                    break;
            }
            command = scanner.nextLine();
        }

//        System.out.println(Arrays.deepToString(treasureChess));
        if (!isFailed) {
            int itemsLength = 0;
            for (String item : treasureChess) {
                itemsLength += item.length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", itemsLength * 1.0 / treasureChess.length);
        }
    }
}
