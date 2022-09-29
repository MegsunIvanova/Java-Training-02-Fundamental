package theme08_TextProcessing.Lab;

import java.util.Scanner;

public class Demo_concat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "Hello, ";
        String name = scanner.nextLine();

        String result = text+name;
        String result2 = text.concat(name);//ako една от променливите  е празна
        // този метод не създава нова променлива

        System.out.println(result);
        System.out.println(result2);

    }
}
