package theme04_Methods.Exercises;

import java.util.Scanner;

public class P04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        //1.Дължина
        //валидна 6 – 10 characters (inclusive);
        //невалидна дължина: "Password must be between 6 and 10 characters";
        boolean isPasswordLengthValid = isValidLength(password);
        if (!isPasswordLengthValid) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        //2. съдържание
        //валидно, ако съдържа само букви и цифри
        //невалидно съдържание: "Password must consist only of letters and digits";
        boolean isPasswordContentValid = isValidContent(password);
        if (!isPasswordContentValid) {
            System.out.println("Password must consist only of letters and digits");
        }

        //3. брой цифри
        //валиден брой цифри 2
        //невалиден брой цифри: "Password must have at least 2 digits".
        boolean isPasswordCountDigitsValid = isValidCountDigits(password);
        if (!isPasswordCountDigitsValid) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isPasswordLengthValid && isPasswordContentValid
                && isPasswordCountDigitsValid) {
            System.out.println("Password is valid");
        }

    }

    //метод за валидиране на дължината
    private static boolean isValidLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    //метод за валидиране на съдържанието
    private static boolean isValidContent(String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    //метод за валидиране на броя на цифрите
    private static boolean isValidCountDigits(String password) {
        int countDigits = 0;

        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                countDigits++;
            }
        }
        return countDigits >= 2;
    }
}
