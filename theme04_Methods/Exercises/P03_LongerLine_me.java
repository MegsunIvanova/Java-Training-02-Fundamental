package theme04_Methods.Exercises;

import java.util.Scanner;

public class P03_LongerLine_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] firstCoordinates = new double[4];
        double[] secondCoordinates = new double[4];


        for (int i = 0; i < firstCoordinates.length; i++) {
            firstCoordinates[i] = Double.parseDouble(scanner.nextLine());
        }

        for (int i = 0; i < secondCoordinates.length; i++) {
            secondCoordinates[i] = Double.parseDouble(scanner.nextLine());
        }

        double firstLineLength = getLineLengthBetweenTwoPoints(firstCoordinates);
        double secondLineLength = getLineLengthBetweenTwoPoints(secondCoordinates);

        if (firstLineLength >= secondLineLength) {
            printCoordinates(firstCoordinates);
        } else {
            printCoordinates(secondCoordinates);
        }
    }

    private static void printCoordinates(double[] coordinates) {
        if (getDistanceFromCenter(coordinates[0], coordinates[1]) >
                getDistanceFromCenter(coordinates[2], coordinates[3])) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)",
                    coordinates[2], coordinates[3], coordinates[0], coordinates[1]);
        } else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)",
                    coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
        }
    }

    private static double getLineLengthBetweenTwoPoints(double[] coordinates) {
        double lineLength = Math.sqrt(Math.pow((coordinates[0] - coordinates[2]), 2)
                + Math.pow((coordinates[1] - coordinates[3]), 2));
        return lineLength;
    }

    private static double getDistanceFromCenter(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }
}
