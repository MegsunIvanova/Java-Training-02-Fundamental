package theme05_Lists.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> guestsList = new ArrayList<>();

        for (int i = 1; i <= numberOfCommands; i++) {
            List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());
            String name = input.get(0);
            int inputSize = input.size();

            if (inputSize == 3) {
                //if is going
                addGuest(guestsList, name);

            } else if (inputSize == 4) {
                //if is not going
                removeGuest(guestsList, name);
            }

        }
        System.out.println(guestsList.toString().replace(" ","\n")
                .replaceAll("[\\[\\],]", ""));
    }

    private static void addGuest(List<String> guestsList, String name) {
        if (guestsList.contains(name)) {
            System.out.printf("%s is already in the list!\n", name);
        } else {
            guestsList.add(name);
        }
    }

    private static void removeGuest(List<String> guestsList, String name) {
        if (guestsList.contains(name)) {
            guestsList.remove(name);
        } else {
            System.out.printf("%s is not in the list!\n", name);
        }
    }
}
