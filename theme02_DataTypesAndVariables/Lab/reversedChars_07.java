package theme02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class reversedChars_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);//така се чете char от конзолата
        char secondChar = scanner.nextLine().charAt(0);//така се чете char от конзолата
        char thirdChar = scanner.nextLine().charAt(0);//така се чете char от конзолата

        System.out.printf("%c %c %c", thirdChar, secondChar, firstChar);
    }

}
