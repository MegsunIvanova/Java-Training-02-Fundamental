package theme07_AssociativeArrays.Lab;

import java.util.Arrays;
import java.util.OptionalInt;

public class Demo_StreamAPI {
    public static void main(String[] args) {
        int minNum = Arrays.stream(new int[]{15, 25, 35}).min().getAsInt();
        System.out.println(minNum);
        //ако колекцията е празна може да кажем какво да върне
        int minNum2 = Arrays.stream(new int[0]).min().orElse(100);
        System.out.println(minNum2);


    }
}
