package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06_LadyBug_me_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //On the first line, you will receive an integer - the size of the field.
        int fieldSize = Integer.parseInt(scanner.nextLine());
        //create a field Array
        int[] field = new int[fieldSize];
        //On the second line, you will receive the initial indexes
        // of all ladybugs separated by a blank space.
        // The given indexes may or may not be inside the field range.
        int[] ladyBugIndexes = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        //put the ladybugs in their places in the field
        for (int ladyBugIndex : ladyBugIndexes) {
            if (ladyBugIndex >= 0 && ladyBugIndex < field.length) {
                field[ladyBugIndex] = 1;
            }
        }

        //until the "end" command (ex.: "0 right 1") is given,
        // a ladybug changes its position
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            int index = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int flyLength = Integer.parseInt(tokens[2]);

            if (index >= 0 && index < field.length && field[index] == 1) {
                //калинката излита
                field[index] = 0;
                if (direction.equals("right")) {
                    index += flyLength; //нова позиция
                    //калинката спира да лети: ако на новата позиция няма калинка на новата позиция,
                    //ако калинката излезе извън полето
                    while (index < field.length && field[index] == 1) {
                        index += flyLength;
                    }
                    //Ако калинката е кацнала на полето
                    if (index < field.length) {
                        field[index] = 1;
                    }

                } else if (direction.equals("left")) {
                    index -= flyLength;
                    while (index >= 0 && field[index] == 1) {
                        index -= flyLength;
                    }
                    if (index >= 0) {
                        field[index] = 1;
                    }
                }

            }


            command = scanner.nextLine();
        }


        //field printing
        //For each cell that has a ladybug on it print '1' and for each empty cell print '0'.
        System.out.println(Arrays.toString(field)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));


    }


}
