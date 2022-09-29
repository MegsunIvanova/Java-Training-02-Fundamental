package theme02_DataTypesAndVariables.Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class exactSumOfRealNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for (int i = 1; i <= number; i++) {
            BigDecimal currentNum = new BigDecimal(scanner.nextLine());
            sum = sum.add(currentNum);
        }
        System.out.println(sum);


    }
}
