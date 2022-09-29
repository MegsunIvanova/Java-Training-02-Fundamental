package theme03_Arrays.Exercises;

import java.util.Scanner;

public class P01_EncryptSortAndPrintArray_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //създаване на масив от Strings
        int length = Integer.parseInt(scanner.nextLine());
        String[] stringArr = new String[length];

        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = scanner.nextLine();
        }

        //създаване на масив с кодове
        int[] encryptArr = new int[length];
        for (int elementIndex = 0; elementIndex < length; elementIndex++) {
            int elementEncryptValue = 0;
            String currentElement = stringArr[elementIndex];
            for (int charIndex = 0; charIndex < currentElement.length(); charIndex++) {
                if (currentElement.charAt(charIndex) == 65 ||
                        currentElement.charAt(charIndex) == 69 ||
                        currentElement.charAt(charIndex) == 73 ||
                        currentElement.charAt(charIndex) == 79 ||
                        currentElement.charAt(charIndex) == 85 ||
                        currentElement.charAt(charIndex) == 97 ||
                        currentElement.charAt(charIndex) == 101 ||
                        currentElement.charAt(charIndex) == 105 ||
                        currentElement.charAt(charIndex) == 111 ||
                        currentElement.charAt(charIndex) == 117) {
                    elementEncryptValue = elementEncryptValue + ((int) currentElement.charAt(charIndex)) * currentElement.length();
                } else {
                    elementEncryptValue = elementEncryptValue + ((int) currentElement.charAt(charIndex)) / currentElement.length();
                }

            }
            encryptArr[elementIndex] = elementEncryptValue;
        }

        //подреждане на кодовете
        for (int currentElementIndex = 0; currentElementIndex < encryptArr.length; currentElementIndex++) {
            int minElement = encryptArr[currentElementIndex];
            for (int othersELementIndex = currentElementIndex + 1; othersELementIndex < encryptArr.length; othersELementIndex++) {
                if (encryptArr[currentElementIndex] > encryptArr[othersELementIndex]) {
                    int tempValue = encryptArr[othersELementIndex];
                    encryptArr[othersELementIndex] = encryptArr[currentElementIndex];
                    encryptArr[currentElementIndex] = tempValue;
                }
            }
        }
        //Печатане
        for (int element : encryptArr) {
            System.out.println(element);
        }
    }
}
