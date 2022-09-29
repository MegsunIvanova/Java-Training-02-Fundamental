package theme04_Methods.Exercises;

import java.util.Arrays;

public class Demo_SeparateValuesOFArrayToEvenAndOddArrays {
    public static void main(String[] args) {
        int[] array = new int[]{
                12, 10, 100, 1000
        };

        int[] evenArray = new int[array.length];
        int[] oddArray = new int[array.length];
        int countEven = 0;
        int countOdd = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenArray[countEven] = array[i];
                countEven++;
            } else {
                oddArray[countOdd] = array[i];
                countOdd++;
            }
        }

        evenArray = Arrays.copyOf(evenArray, countEven);
        oddArray = Arrays.copyOf(oddArray, countOdd);
        System.out.println(Arrays.toString(evenArray));
        System.out.println(Arrays.toString(oddArray));

    }


}
