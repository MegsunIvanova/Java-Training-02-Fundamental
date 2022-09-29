package theme05_Lists.Lab;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Demo_ListsOverview {
    public static void main(String[] args) {

        List<String> namesList = new ArrayList<>();

//Create a list of strings
        namesList.add("Veronika");  // добавя елемент към List-a
        namesList.add("Java");
        namesList.add("J");
        namesList.add("asd");
        namesList.add("George");
        namesList.remove("George"); //Премахва елемент от List-a
        namesList.set(3, "Raya");
        namesList.add("Veronika");

        if (namesList.contains("Java")) {
            System.out.println("YES");
        }

        for (String name : namesList)
            System.out.println(name);
//Peter, George
    }
}
