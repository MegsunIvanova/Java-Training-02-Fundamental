package theme05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> bombs = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int[] detonationData = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        int specialBombValue = detonationData[0];
        int detonationPower = detonationData[1];

        for (int index = 0; index < bombs.size(); index++) {
            int bombValue = bombs.get(index);
            if (bombValue == specialBombValue) {
                int startIndex = index - detonationPower;
                int endIndex = index + detonationPower;
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > bombs.size() - 1) {
                    endIndex = bombs.size() - 1;
                }

                bombs.subList(startIndex, endIndex+1).clear();
                index = -1;

            }

        }
        int sum = 0;
        for (Integer bombValue : bombs) {
            sum += bombValue;
        }
        System.out.println(sum);
//       System.out.println(bombs.toString()
//               .replaceAll("[\\[\\],]", ""));
    }
}
