package theme02_DataTypesAndVariables.Exercises;

import java.math.BigDecimal;
import java.util.Scanner;

public class floatingEquality_03me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        BigDecimal firstNum = scanner.nextBigDecimal();
//        BigDecimal secondNum = scanner.nextBigDecimal();
//
//        BigDecimal diff = firstNum.subtract(secondNum).abs();
//
////        if (dif. 0.000001) {
////            System.out.println("True");
////        } else {
////            System.out.println("False");
////        }
        double firstNum = Double.parseDouble(scanner.nextLine());
        double secondNum = Double.parseDouble(scanner.nextLine());

        if (Math.abs(firstNum - secondNum) < 0.000001) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
