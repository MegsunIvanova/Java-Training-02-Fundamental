package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class triangleOfNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int rows = 1; rows <= num; rows++) {
            for (int cols = 1; cols <= rows; cols++) {
                System.out.print(rows+" ");
            }
            System.out.println();
        }
    }
}
