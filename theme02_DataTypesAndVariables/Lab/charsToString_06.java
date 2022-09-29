package theme02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class charsToString_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);//така се чете char от конзолата
        char secondChar = scanner.nextLine().charAt(0);//така се чете char от конзолата
        char thirdChar = scanner.nextLine().charAt(0);//така се чете char от конзолата

        String combination = "" + firstChar + secondChar + thirdChar;
        System.out.println(combination);

    }
}
