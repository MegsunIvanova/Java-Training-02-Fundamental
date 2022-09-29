package theme05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09_PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distances = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sumRemoved = 0;

        while (distances.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            //индексът е <0
            if (index < 0) {
                int firstElement = distances.get(0); // премахнат елемент
                sumRemoved += firstElement;
                int lastElement = distances.get(distances.size() - 1);
                distances.set(0, lastElement);
                //модификация на списъка
                modifyList(distances, firstElement);

            } else if (index > distances.size() - 1) {
                //индексът е >последния
                int firstElement = distances.get(0);
                int lastElement = distances.get(distances.size() - 1);// премахнат елемент
                sumRemoved += lastElement;
                distances.set(distances.size() - 1, firstElement);
                //модификация на списъка
                modifyList(distances, lastElement);

            } else if (index >= 0 && index <= distances.size() - 1) {
                //индексът е между 0 и последния
                int removedElement = distances.get(index);
                sumRemoved += removedElement;
                distances.remove(index);
                //модификация на списъка
                modifyList(distances, removedElement);
            }
        }

        System.out.println(sumRemoved);
    }

    private static void modifyList(List<Integer> list, int removedElement) {
        for (int index = 0; index < list.size(); index++) {
            int currentElement = list.get(index);

            if (currentElement <= removedElement) {
                currentElement += removedElement;
            } else {
                currentElement -= removedElement;
            }
            list.set(index,currentElement);
        }
    }
}
