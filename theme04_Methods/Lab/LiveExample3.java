package theme04_Methods.Lab;

import java.util.Scanner;

public class LiveExample3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textInput = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());
        print(textInput);
        print(textInput, num);
    }

    //overloading methods:
    public static void print(String text) {
        System.out.println(text);
    }

    public static void print(String text, int n) {
        System.out.println(text + " " + n);
    }
}
