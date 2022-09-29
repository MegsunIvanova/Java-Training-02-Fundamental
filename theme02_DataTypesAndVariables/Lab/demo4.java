package theme02_DataTypesAndVariables.Lab;

public class demo4 {
    public static void main(String[] args) {
        //Sometimes floating-point numbers work incorrectly!
        //Read more about IEEE 754
        double sum = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
        if (sum == 1) {
            System.out.println("True");
        } else {
            System.out.println(sum);
        }
    }
}
