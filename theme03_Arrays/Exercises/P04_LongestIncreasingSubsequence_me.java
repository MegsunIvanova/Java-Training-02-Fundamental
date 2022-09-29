package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04_LongestIncreasingSubsequence_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //вземаме числовата редица от козолата:
        int[] numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        //създаваме два масива:
        // - lenArr, който ще държи дължината най-дългата редица
        // до текущия елемент със същия индекс; и
        // - prevSubsequenceIndexArr - индексът на предходния елемент
        // от редицата, чиято дължина сме пресметнали в lenArr
        int[] lenArr = new int[numArr.length];
        int[] prevSubsequenceIndexArr = new int[numArr.length];

        //цикъл за запълване на данни в lenArr и prevSubsequenceIndexArr
        int maxLen = 0;
        int lastIndex = -1;
        for (int i = 0; i < numArr.length; i++) {
            int currentNum = numArr[i];
            lenArr[i] = 1;
            prevSubsequenceIndexArr[i] = -1;

            for (int j = 0; j < i; j++) {
                int previousNum = numArr[j];
                int previousNumLen = lenArr[j];

                if (previousNum < currentNum && previousNumLen + 1 > lenArr[i]) {
                    lenArr[i] = previousNumLen + 1;
                    prevSubsequenceIndexArr[i] = j;
                }
            }
            if (lenArr[i] > maxLen) {
                maxLen = lenArr[i];
                lastIndex = i;

            }
        }

        int[] subsequenceArr = new int[maxLen];
        for (int i = maxLen - 1; i >= 0; i--) {
            subsequenceArr[i] = numArr[lastIndex];
            lastIndex = prevSubsequenceIndexArr[lastIndex];
        }

        System.out.println(Arrays.toString(subsequenceArr)
                .replace("[","")
                .replace("]","")
                .replace(",",""));

    }
}