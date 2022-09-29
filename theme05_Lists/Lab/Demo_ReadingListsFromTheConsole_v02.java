package theme05_Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo_ReadingListsFromTheConsole_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Lists can be read from a single line of space separated values:
        //2 8 30 25 40 72 -2 44 56
        String inputLine = scanner.nextLine();
        List<String> items = Arrays.stream(inputLine.split(" "))
                .collect(Collectors.toList());

        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < items.size() ; i++) {
            numbersList.add(Integer.parseInt(items.get(i)));
        }

        List<Integer> newList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

    }
}
