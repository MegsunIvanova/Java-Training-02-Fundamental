package tema01_BasicSyntaxConditionalStatementsAndLoops_Exercise;

import java.util.Scanner;

public class padawanEquipment_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int studentsNum = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        double lightsabersSum = Math.ceil(studentsNum * 1.10) * lightsabersPrice;
        double robesSum = studentsNum * robesPrice;
        int beltsFree = studentsNum / 6;
        double beltsSum = (studentsNum - beltsFree) * beltsPrice;
        double totalSum = lightsabersSum + robesSum + beltsSum;

        if (totalSum <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalSum - budget);
        }


    }
}
