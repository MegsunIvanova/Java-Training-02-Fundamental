package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06_LadyBug_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //On the first line, you will receive an integer - the size of the field.
        int fieldLength = Integer.parseInt(scanner.nextLine());
        //create a field Array
        int[] field = new int[fieldLength];


        //On the second line, you will receive the initial indexes
        // of all ladybugs separated by a blank space.
        // The given indexes may or may not be inside the field range.
        int[] ladyBugInitialIndexes = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        //put the ladybugs in their places in the field
        for (int ladyBugIndex : ladyBugInitialIndexes) {
            if (ladyBugIndex <= fieldLength - 1) {
                field[ladyBugIndex] = 1;
            }
        }


        //until the "end" command (ex.: "0 right 1") is given,
        // a ladybug changes its position
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandDetails = command.split(" ");
            field = getFieldAfterFly(field, commandDetails);

            command = scanner.nextLine();
        }


        //field printing
        //For each cell that has a ladybug on it print '1' and for each empty cell print '0'.
        System.out.println(Arrays.toString(field)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));


    }

    private static int[] getFieldAfterFly(int[] field, String[] commandDetails) {
        //variables for command details:
        int indexOfFlyingLadybug = Integer.parseInt(commandDetails[0]);

        if (indexOfFlyingLadybug >= 0 && indexOfFlyingLadybug < field.length
                && field[indexOfFlyingLadybug] == 1) {
            //freeing up space in the field
            field[indexOfFlyingLadybug] = 0;
            int newLadybugIndex = getNewLadyBugIndex(field, commandDetails);
            if (newLadybugIndex == -1) {
                return field;
            } else {
                //if the ladybug has landed:
                field[newLadybugIndex] = 1;
                return field;
            }


        }
        return field;
    }

    private static int getNewLadyBugIndex(int[] field, String[] commandDetails) {

        String direction = commandDetails[1];
        int flyLength = Integer.parseInt(commandDetails[2]);

        int newLadybugIndex = Integer.parseInt(commandDetails[0]);
        //if direction is right -> newIndex = indexFLB+flyLength;
        if (direction.equals("right")) {
            newLadybugIndex += flyLength;
        } //else direction is left -> newIndex = indexFLB-flyLength;
        else if (direction.equals("left")) {
            newLadybugIndex -= flyLength;
        }

        //check new index: if LB is still in field:
        if (newLadybugIndex >= 0 && newLadybugIndex < field.length) {
            //if the new index is free, ladybug lands ot the new index,
            // if new index isn't free ladyBug continues to fly:
            if (field[newLadybugIndex] != 0) {
                commandDetails[0] = "" + newLadybugIndex;
                getNewLadyBugIndex(field, commandDetails);
            }
        } else {
            //if ladybug is gone
            newLadybugIndex = -1;
        }
        return newLadybugIndex;
    }
}