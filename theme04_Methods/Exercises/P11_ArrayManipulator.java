package theme04_Methods.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P11_ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            //създаване на масив за командата
            String[] commandArr = command.split(" ");
            String action = commandArr[0];
            switch (action) {
                case "exchange":
                    int splitIndex = Integer.parseInt(commandArr[1]);
                    numArr = splitAndExchangeArrByIndex(numArr, splitIndex);
//                    System.out.println(Arrays.toString(numArr));
                    break;
                case "max":
                    String typeOfMaxNum = commandArr[1];
                    printMaxEvenOrOddElement(numArr, typeOfMaxNum);
                    break;
                case "min":
                    String typeOfMinNum = commandArr[1];
                    printMinEvenOrOddElement(numArr, typeOfMinNum);
                    break;
                case "first":
                    int numberOfFirstElements = Integer.parseInt(commandArr[1]);
                    String typeOfFirstNumbers = commandArr[2];
                    printFirstCountEvenOddElements(numArr, numberOfFirstElements, typeOfFirstNumbers);
                    break;
                case "last":
                    int numberOfLastElements = Integer.parseInt(commandArr[1]);
                    String typeOfLastNumbers = commandArr[2];
                    printLastCountEvenOddElements(numArr, numberOfLastElements, typeOfLastNumbers);
                    break;
            }


            //
            command = scanner.nextLine();
        }
        System.out.println(Arrays.toString(numArr));
    }

    //проверява дали сплит индекса е в границите на масива
    private static boolean isSplitIndexInsideArrayBoundaries(int[] array, int splitIndex) {
        return (splitIndex >= 0 && splitIndex < array.length);
    }

    //разделя по валиден индекс и пренарежда двете части на масива в нов масив
    private static int[] splitAndExchangeArrByIndex(int[] array, int index) {
        if (!isSplitIndexInsideArrayBoundaries(array, index)) {
            System.out.println("Invalid index");
            return array;
        } else {
            int[] exchangedArr = new int[array.length];
            int indexOfOldElement = index + 1;

            for (int i = 0; i < array.length; i++) {
                if (indexOfOldElement > array.length - 1) {
                    indexOfOldElement = 0;
                }
                exchangedArr[i] = array[indexOfOldElement];
                indexOfOldElement++;
            }
            return exchangedArr;
        }
    }

    //търси и принтира индекса на максималния четен/нечетен елемент в масива
    private static void printMaxEvenOrOddElement(int[] array, String numType) {
        int maxEvenNum = Integer.MIN_VALUE;
        int maxOddNum = Integer.MIN_VALUE;

        int indexOfMaxEvenElement = -1;
        int indexOfMaxOddElement = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (maxEvenNum <= array[i]) {
                    maxEvenNum = array[i];
                    indexOfMaxEvenElement = i;
                }
            } else if (array[i] % 2 != 0) {
                if (maxOddNum <= array[i]) {
                    maxOddNum = array[i];
                    indexOfMaxOddElement = i;
                }
            }
        }

        if (indexOfMaxEvenElement != -1 && numType.equals("even")) {
            System.out.println(indexOfMaxEvenElement);
        } else if (indexOfMaxOddElement != -1 && numType.equals("odd")) {
            System.out.println(indexOfMaxOddElement);
        } else {
            System.out.println("No matches");
        }
    }

    //търси и принтира индекса на минималния четен/нечетен елемент в масива
    private static void printMinEvenOrOddElement(int[] array, String numType) {
        int minEvenNum = Integer.MAX_VALUE;
        int minOddNum = Integer.MAX_VALUE;

        int indexOfMinEvenElement = -1;
        int indexOfMinOddElement = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (minEvenNum >= array[i]) {
                    minEvenNum = array[i];
                    indexOfMinEvenElement = i;
                }
            } else if (array[i] % 2 != 0) {
                if (minOddNum >= array[i]) {
                    minOddNum = array[i];
                    indexOfMinOddElement = i;
                }
            }
        }

        if (indexOfMinEvenElement != -1 && numType.equals("even")) {
            System.out.println(indexOfMinEvenElement);
        } else if (indexOfMinOddElement != -1 && numType.equals("odd")) {
            System.out.println(indexOfMinOddElement);
        } else {
            System.out.println("No matches");
        }
    }

    //проверява N, създава и принтира масив с пъвите N четни/нечетни елементи
    private static void printFirstCountEvenOddElements(int[] array
            , int numberOfElements, String typeOfElements) {

        if (numberOfElements > array.length) {
            System.out.println("Invalid count");
        } else {

            if (typeOfElements.equals("even")) {
                int[] evenArray = getNewArrayOfEvenElements(array);
                printFirstNElementsOfArray(evenArray, numberOfElements);
            } else if (typeOfElements.equals("odd")) {
                int[] oddArray = getNewArrayOfOddElements(array);
                printFirstNElementsOfArray(oddArray, numberOfElements);
            }
        }

    }

    //създава и принтира масив с първите N елементи
    private static void printFirstNElementsOfArray(int[] array
            , int numberOfFirstElements) {
        if (numberOfFirstElements < array.length) {
            array = Arrays.copyOfRange(array
                    , 0, numberOfFirstElements);
        }
        System.out.println(Arrays.toString(array));
    }

    //проверява N, създава и принтира масив с последните N четни/нечетни елементи
    private static void printLastCountEvenOddElements(int[] array
            , int numberOfElements, String typeOfElements) {

        if (numberOfElements > array.length) {
            System.out.println("Invalid count");
        } else {

            if (typeOfElements.equals("even")) {
                int[] evenArray = getNewArrayOfEvenElements(array);
                printLastNElementsOfArray(evenArray, numberOfElements);
            } else if (typeOfElements.equals("odd")) {
                int[] oddArray = getNewArrayOfOddElements(array);
                printLastNElementsOfArray(oddArray, numberOfElements);
            }
        }


    }

    //създава и принтира масив с последните N елементи
    private static void printLastNElementsOfArray(int[] array
            , int numberOfLastElements) {

        if (numberOfLastElements < array.length) {
            array = Arrays.copyOfRange(array
                    , array.length - numberOfLastElements, array.length);
        }
        System.out.println(Arrays.toString(array));
    }

    //получава масив и създава нов масив само с четните му елементи
    private static int[] getNewArrayOfEvenElements(int[] array) {
        int[] evenArray = new int[array.length];
        int countEven = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenArray[countEven] = array[i];
                countEven++;
            }
        }
        evenArray = Arrays.copyOf(evenArray, countEven);

        return evenArray;
    }

    //получава масив и създава нов масив само с нечетните му елементи
    private static int[] getNewArrayOfOddElements(int[] array) {
        int[] oddArray = new int[array.length];
        int countOdd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddArray[countOdd] = array[i];
                countOdd++;
            }
        }
        oddArray = Arrays.copyOf(oddArray, countOdd);

        return oddArray;
    }
}
