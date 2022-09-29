package theme06_BitwiseOperations.Lab;

public class Demo_Shifting {
    public static void main(String[] args) {

        byte a = 64, b;
        int i;

        i = a << 2;
        b = (byte)(a << 2);
        System.out.println("Original value of a: " + a);
        System.out.println("i and b: " + i + " " + b);
    }
}
