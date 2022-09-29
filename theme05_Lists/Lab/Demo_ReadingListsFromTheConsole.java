package theme05_Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo_ReadingListsFromTheConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //First, read from the console the array length:
        int n = Integer.parseInt(scanner.nextLine());
        //Next, create a list of given size n and read its elements:
        List<Integer> numbetsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            numbetsList.add(currentNum);
        }
        for (int num :numbetsList) {
            System.out.println(num);
        }
        //Lists can be read from a single line of space separated values:
        //input: 2 8 30 25 40 72 -2 44 56
//        String values = scanner.nextLine();
//        List<String> items = Arrays.stream(values.split(" "))
//                .collect(Collectors.toList());



    }
}
