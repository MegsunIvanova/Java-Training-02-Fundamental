package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigNum = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        if (bigNum.isEmpty()) {
            bigNum = "0";
        }
        int multiplier = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        if (bigNum.equals("0") || multiplier == 0) {
            result.append(0);
        } else {
            char[] bigNumArr = bigNum.toCharArray();
            int remaining = 0;
            for (int i = bigNumArr.length - 1; i >= 0; i--) {
                int currentDigit = Integer.parseInt(String.valueOf(bigNumArr[i]));
                int currentResult = currentDigit * multiplier + remaining;
                String valueToResult = Integer.toString(currentResult % 10);
                remaining = currentResult / 10;
                result.insert(0, valueToResult);
            }
            if (remaining > 0) {
                result.insert(0, Integer.toString(remaining));
            }
        }
        System.out.println(result.toString());
    }
}
