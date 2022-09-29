package theme04_Methods.Lab;

import java.util.Scanner;

public class LiveExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //тук извикваме методи, дефинирани по-долу
        printHello();
        printText("Java");
        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());

        printNumbers(startNum, endNum);

    }

    //това са методите (могат да са записани преди main Метода или в отделни класове:

    public static void printHello() {
        System.out.println("Hello!");
    }

    public static void printText(String text) {
        System.out.println(text);
    }

    public static void printNumbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", i);
        }
    }

}
