package theme06_ObjectsAndClasses.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        Random rnd = new Random();

        while (!wordsList.isEmpty()) {

            int randomIndex = rnd.nextInt(wordsList.size());

            System.out.println(wordsList.get(randomIndex));
            wordsList.remove(randomIndex);
        }

    }

}
