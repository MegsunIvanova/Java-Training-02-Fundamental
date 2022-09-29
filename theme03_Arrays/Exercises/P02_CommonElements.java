package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] firstArr = scanner.nextLine().split(" ");
        String [] secondArr = scanner.nextLine().split(" ");

//        for (int i = 0; i < firstArr.length; i++) {
//            for (int j = 0; j < secondArr.length; j++) {
//                if (firstArr[i].equals(secondArr [j])) {
//                    System.out.printf(firstArr[i]+" ");
//                }
//            }
//        }

        for (String secondElement : secondArr) {
            for (String firstELement : firstArr) {
                if (firstELement.equals(secondElement)) {
                    System.out.printf(firstELement+" ");
                }
            }
        }
    }
}
