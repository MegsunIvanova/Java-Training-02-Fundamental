package theme05_Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo_ListsOverview2 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60));
        nums.remove(2); //Премахва елемент от даден индекс
        nums.remove(Integer.valueOf(40)); //Премахва елемент с дадена стойност
        nums.add(100); //добавя елемент в края на списъка
        nums.add(0, -100); //добавя елемент на посочен индекс
        for (int i = 0; i < nums.size(); i++)
            System.out.print(nums.get(i) + " ");

        //List<E> holds a list of elements (like array, but extendable)
        //Provides operations to add / insert / remove / find elements:

        //size() – number of elements in the List<E>
        //add(element) – adds an element to the List<E>
        //add(index, element) – inserts an element to given position
        //remove(element) – removes an element (returns true / false)
        //remove(index) – removes element at index
        //contains(element) – determines whether an element is in the list
        //set(index, item) – replaces the element at  the given index

    }
}
