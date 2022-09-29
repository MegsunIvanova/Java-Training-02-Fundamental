package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P01_ExtractPersonInformation_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            int firstIndexOfName = input.indexOf('@') + 1;
            int lastIndexOfName = input.indexOf('|');
            String name = input.substring(firstIndexOfName, lastIndexOfName);

            int firstIndexOfAge = input.indexOf('#') + 1;
            int lastIndexOfAge = input.indexOf('*');
            int age = Integer.parseInt(input.substring(firstIndexOfAge, lastIndexOfAge));

            System.out.printf("%s is %d years old.\n", name, age);
        }


    }
}
