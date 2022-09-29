package theme02_DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class balancedBrackets_06me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean isBalanced = false;

        int counter = 0;
        char lastBracket = 0;

        for (int i = 1; i <= number; i++) {
            String input = scanner.nextLine();

            if (input.length() == 1) {
                char symbol = input.charAt(0);
                if (symbol == 40 && lastBracket != 40) {
                    counter++;
                    if (lastBracket == 41 && counter % 2 == 0) {
                        isBalanced = true;
                    } else {
                        isBalanced = false;
                    }
                    lastBracket = symbol;


                } else if (symbol == 41 && lastBracket != 41) {
                    counter++;
                    if (lastBracket == 40 && counter % 2 == 0) {
                        isBalanced = true;
                    } else {
                        isBalanced = false;
                    }
                    lastBracket = symbol;


                } else if (symbol == lastBracket) {
                    isBalanced = false;
                    break;
                }

            }

        }
        if (isBalanced) {
            System.out.println("BALANCED");
        } else {

            System.out.println("UNBALANCED");
        }
    }
}
