package theme03_Arrays.Lab;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = new int[3];
        numbersArr[0] = Integer.parseInt(scanner.nextLine());
        numbersArr[1] = Integer.parseInt(scanner.nextLine());
        numbersArr[2] = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbersArr.length; i++) {
//            System.out.println(numbersArr[i]);
            int currentElement = numbersArr[i];
            System.out.println(currentElement);
        }

//        int num1 = 10;
//        int num2 = 20;
//        int num3 = 30;
//
//        System.out.println(num1);
//        System.out.println(num2);
//        System.out.println(num3);

    }
}
