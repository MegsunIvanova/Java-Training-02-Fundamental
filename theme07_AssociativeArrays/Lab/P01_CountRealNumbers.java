package theme07_AssociativeArrays.Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read an array of real numbers (double).
        double[] numbersArr = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToDouble(Double::parseDouble).toArray();
        //Use TreeMap<Double, Integer> named countNumbersMap
        TreeMap<Double, Integer> countNumbersMap = new TreeMap<>();
        //8 2 2 8 2
        for (double currentNum : numbersArr) {
            //ВАРИАНТ 1:
//            if (!countNumbersMap.containsKey(currentNum)) {
//                countNumbersMap.put(currentNum, 1);
//            } else {
//                int newValue = countNumbersMap.get(currentNum) + 1;
//                countNumbersMap.put(currentNum, newValue);
//            }
            //ВАРИАНТ 2:
            countNumbersMap.putIfAbsent(currentNum, 0);
            int newValue = countNumbersMap.get(currentNum) + 1;
            countNumbersMap.put(currentNum, newValue);
        }
        for (Map.Entry<Double, Integer> entry : countNumbersMap.entrySet()) {
//            DecimalFormat df = new DecimalFormat ("# ###.##");
            System.out.printf("%.0f -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
