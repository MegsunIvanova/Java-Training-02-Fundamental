package theme02_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte centuries = 20;
        short years = 2000;
        int days = 730484;
        long hours = 17531616;

        System.out.printf("%d centuries = %d years = %d days = %d hours.",
                centuries, years, days, hours);



    }
}
