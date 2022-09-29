package theme06_ObjectsAndClasses.Lab;

import java.time.LocalDate;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());

        LocalDate birthdayVeronika = LocalDate.of(1986,4,19);//инстанция (обект) на клас LocalDate
        LocalDate birthdayAtanas = LocalDate.of(1984,3,25);

        birthdayVeronika = birthdayVeronika.plusYears(36);

        System.out.println(birthdayVeronika);
    }
}
