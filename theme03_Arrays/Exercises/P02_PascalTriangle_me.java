package theme03_Arrays.Exercises;

import java.util.Scanner;

public class P02_PascalTriangle_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int[] area = new int[number];
        area[0] = 1;

        for (int row = 0; row < area.length; row++) {
            int oldValue = 1;
            for (int index = 0; index <= row; index++) {
                if (index > 0) {
                    int newValue = area[index] + oldValue;
                    oldValue = area[index];
                    area[index] = newValue;
                }
                if (area[index] > 0) {
                    System.out.print(area[index] + " ");
                }
            }
            System.out.println();
        }
    }
}
