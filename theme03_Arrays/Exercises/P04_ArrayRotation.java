package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int countRotations = Integer.parseInt(scanner.nextLine());

        for (int rotation = 1; rotation <= countRotations; rotation++) {
            //ротация на масива
            //1.вземаме първия елемент
            String firstElement = array[0];
            //2.изместване на всички елементи на ляво
            for (int i = 1; i < array.length; i++) {
                array[i - 1] = array[i];
            }
            //3.да сложим първия елемент на последна позиция
            array[array.length - 1] = firstElement;
        }

        for (String element : array) {
            System.out.print(element + " ");

        }
    }
}
