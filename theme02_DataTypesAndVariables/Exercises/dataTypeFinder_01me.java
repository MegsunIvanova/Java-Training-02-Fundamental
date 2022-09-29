package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class dataTypeFinder_01me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }

            try {
                int integer = Integer.parseInt(input);
                System.out.printf("%s is integer type\n", input);
                continue;
            } catch (NumberFormatException e) {
            }


            try {
                double floatingPoint = Double.parseDouble(input);
                ;
                System.out.printf("%s is floating point type\n", input);
                continue;
            } catch (NumberFormatException e) {
            }

            if (input.length() == 1) {
                System.out.printf("%s is character type\n", input);
                continue;
            }

            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type\n", input);

            } else {
                System.out.printf("%s is string type\n", input);
            }


        }

    }
}
