package theme03_Arrays.Exercises;

import java.util.Scanner;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] trainArr = new int[n];
        int sum = 0;

        for (int i = 0; i < trainArr.length; i++) {
            trainArr[i] = Integer.parseInt(scanner.nextLine());
            sum += trainArr[i];
            System.out.print(trainArr[i] + " ");
        }
        System.out.println();
        System.out.println(sum);

    }
}
