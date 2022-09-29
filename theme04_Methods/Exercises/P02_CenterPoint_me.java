package theme04_Methods.Exercises;

import java.util.Scanner;

public class P02_CenterPoint_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());

        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        double distance1 = getDistanceFromCenter(x1, y1);
        double distance2 = getDistanceFromCenter(x2, y2);

        if (distance1 <= distance2) {
            printCoordinates(x1, y1);
        } else {
            printCoordinates(x2, y2);
        }
    }

    private static void printCoordinates(int x, int y) {
        System.out.printf("(%d, %d)", x, y);
    }

    private static double getDistanceFromCenter(int x, int y) {
        return Math.sqrt(x * x * 1.0 + y * y * 1.0);
    }


}
