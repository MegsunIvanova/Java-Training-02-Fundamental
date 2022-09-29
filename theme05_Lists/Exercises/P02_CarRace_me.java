package theme05_Lists.Exercises;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_CarRace_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> timeList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int middleIndex = timeList.size() / 2;
        List<Integer> leftPlayerTimeList = timeList.subList(0, middleIndex);
        List<Integer> rightPlayerTimeList = timeList.subList(middleIndex + 1, timeList.size());
        Collections.reverse(rightPlayerTimeList);

        double leftPlayerTotalTime = getTotalTime(leftPlayerTimeList);
        double rightPlayerTotalTime = getTotalTime(rightPlayerTimeList);

        if (leftPlayerTotalTime<rightPlayerTotalTime) {
            System.out.printf("The winner is left with total time: %.1f",leftPlayerTotalTime);
        } else if (rightPlayerTotalTime<leftPlayerTotalTime) {
            System.out.printf("The winner is right with total time: %.1f",rightPlayerTotalTime);
        }

    }

    private static double getTotalTime(List<Integer> list) {
        double totalTime = 0;
        for (Integer number : list) {
            totalTime += number;
            if (number == 0) {
                totalTime *= 0.80;
            }
        }
        return totalTime;
    }
}
