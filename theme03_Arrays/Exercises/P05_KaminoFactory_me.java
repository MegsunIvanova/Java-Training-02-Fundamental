package theme03_Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_KaminoFactory_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int bestDNA[] = new int[size];
        int bestDNAStartIndexLS = Integer.MAX_VALUE;
        int bestDNALenLS = Integer.MIN_VALUE;
        int bestDNASum = Integer.MIN_VALUE;
        int bestSampleNum = 0;
        int countSamples = 0;

        String input = scanner.nextLine();
        while (!input.equals("Clone them!")) {
            countSamples++;
            int[] currentArrayDNA = Arrays.stream(input
                            .replaceAll("[^0-9]+", " ")
                            .split(" ")).mapToInt(Integer::parseInt).toArray();
            int currentArrayLSLen = getLSLenAndItsStartIndex(currentArrayDNA)[0];
            int currentArrStartIndexLS = getLSLenAndItsStartIndex(currentArrayDNA)[1];
            int currentArrSum = getLSLenAndItsStartIndex(currentArrayDNA)[2];
            if ((currentArrayLSLen > bestDNALenLS)
                    || (currentArrayLSLen == bestDNALenLS && currentArrStartIndexLS < bestDNAStartIndexLS)
                    || (currentArrayLSLen == bestDNALenLS && currentArrStartIndexLS == bestDNAStartIndexLS
                    && currentArrSum > bestDNASum)) {
                bestDNA = currentArrayDNA;
                bestDNAStartIndexLS = currentArrStartIndexLS;
                bestDNALenLS = currentArrayLSLen;
                bestDNASum = currentArrSum;
                bestSampleNum = countSamples;
            }

            input = scanner.nextLine();
        }
        if (countSamples > 0) {
            System.out.printf("Best DNA sample %d with sum: %d.\n", bestSampleNum, bestDNASum);
            System.out.printf(Arrays.toString(bestDNA)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }

    private static int[] getLSLenAndItsStartIndex(int[] array) {
        int arrayLSLen = 0;
        int startIndexArrayLS = Integer.MAX_VALUE;


        for (int i = 0; i < array.length; i++) {
            int currentSQLen = 1;
            for (int j = i + 1; j < array.length; j++) {
                int element = array[i];
                int nextElement = array[j];
                if (element == nextElement) {
                    currentSQLen++;
                } else {
                    break;
                }
            }
            if (currentSQLen > arrayLSLen) {
                arrayLSLen = currentSQLen;
                startIndexArrayLS = i;
            }

        }

        int arraySum = 0;
        for (int element : array) {
            if (element == 1) {
                arraySum++;
            }
        }

        return new int[]{arrayLSLen, startIndexArrayLS, arraySum};
    }
}
