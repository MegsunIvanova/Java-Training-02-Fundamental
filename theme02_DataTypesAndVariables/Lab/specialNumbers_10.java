    package theme02_DataTypesAndVariables.Lab;

    import java.util.Scanner;

    public class specialNumbers_10 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int number = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= number; i++) {
                int currentNum = i;
                int sum = 0;
                while (currentNum > 0) {
                    int currentDigit = currentNum % 10;
                    sum += currentDigit;
                    currentNum /= 10;
                }
                boolean isSpecial = (sum == 5 || sum == 7 || sum == 11);
                if (isSpecial) {
                    System.out.printf("%d -> True\n", i);
                } else {
                    System.out.printf("%d -> False\n", i);
                }
            }
        }
    }
