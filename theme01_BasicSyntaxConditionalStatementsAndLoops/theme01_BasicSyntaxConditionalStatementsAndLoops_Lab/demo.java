package tema01_BasicSyntaxConditionalStatementsAndLoops_Lab;

public class demo {
    public static void main(String[] args) {
        int percentage = 55;
        double grade = 5.5334;
        System.out.printf("%03d\n", percentage);   // 055
        System.out.printf("%.2f\n\n", grade);// 5.53

        String name = "George";
        int age = 5;
        String result = String.format("Name: %s, Age: %d", name, age);
        System.out.println(result);
//Name: George, Age 5

    }
}
