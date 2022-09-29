package theme05_Lists.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P04_MixedUpLists_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int minSize = 0;
        int rangeFrom = 0;
        int rangeTo = 0;

        if (firstList.size() > secondList.size()) {
            minSize = secondList.size();
            rangeFrom = Math.min(firstList.get(firstList.size() - 2), firstList.get(firstList.size() - 1));
            rangeTo = Math.max(firstList.get(firstList.size() - 2), firstList.get(firstList.size() - 1));
        } else {
            minSize = firstList.size();
            rangeFrom = Math.min(secondList.get(0), secondList.get(1));
            rangeTo = Math.max(secondList.get(0), secondList.get(1));
        }

        List<Integer> resultList = new ArrayList<>();
        int secondIndex = secondList.size() - 1;

        for (int firstIndex = 0; firstIndex < minSize; firstIndex++) {
            resultList.add(firstList.get(firstIndex));
            resultList.add(secondList.get(secondIndex));
            secondIndex--;
        }

        for (int i = 0; i < resultList.size(); i++) {
            if (!(resultList.get(i) > rangeFrom && resultList.get(i) < rangeTo)) {
                resultList.remove(i);
                i--;
            }
        }

        Collections.sort(resultList);

        System.out.println(resultList.toString()
                .replaceAll("[\\[\\],]", ""));

    }
}

