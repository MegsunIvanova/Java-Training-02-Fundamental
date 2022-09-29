package theme07_AssociativeArrays.Lab;

import java.util.*;

public class Demo_AssociativeArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //създаване:
        Map<String, Integer> map = new LinkedHashMap<>();
        //добавяне на елементи:
        map.put("Veronika", 3598851);
        map.put("Ivan", 8851);
        map.put("Atanas", 22222);
        //премахване на елементи:
        map.remove("Atanas");
        //итериране/принтиране:
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
        //проверка дали в структурата има елемент с даден ключ
        if (map.containsKey("Veronika")) {
            System.out.println("YES");
        }
    }
}
