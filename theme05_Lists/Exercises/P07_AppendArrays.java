package theme05_Lists.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P07_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
//        Character[] input = scanner.nextLine().chars().mapToObj(c -> (char) c)
//                .toArray(Character[]::new);

        //Създавме List с елементи - подстринговете, които са разделени в input с |
        //"1 2 3 |4 5 6 |  7  8" -> split -> ["1 2 3 ", "4 5 6 ", "  7  8"] -> {"1 2 3 ", "4 5 6 ", "  7  8"}
        List<String> stringsSeparatedByPipe = Arrays.stream(input.split("\\|"))
                .collect(Collectors.toList());

        //обръщаме елементите на колекцията наобратно
        // reverse ->  {"  7  8", "4 5 6 ", "1 2 3 "}
        Collections.reverse(stringsSeparatedByPipe);

        //list.toString() -> "7 8 4 5 6 1 2 3"

        for (int i = 0; i < stringsSeparatedByPipe.size(); i++) {
            String currentString = stringsSeparatedByPipe.get(i);
            currentString = currentString.trim();
            currentString = currentString.replaceAll("\\s+", " ");
            stringsSeparatedByPipe.set(i, currentString);

        }

        System.out.println(stringsSeparatedByPipe.toString()
                .replace("[", "") //"  7  8, 4 5 6 , 1 2 3 ]"
                .replace("]", "") //"  7  8, 4 5 6 , 1 2 3 "
                .trim() //"7  8, 4 5 6 , 1 2 3"
                .replaceAll(",", "") //"7  8 4 5 6  1 2 3"
                .replaceAll("\\s+"," ")); //"7 8 4 5 6 1 2 3"
    }
}
