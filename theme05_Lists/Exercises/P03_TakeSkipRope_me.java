package theme05_Lists.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_TakeSkipRope_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        String encryptedMessageNonNumbers = encryptedMessage.replaceAll("\\d", "");
        String encryptedMessageNumbers = encryptedMessage.replaceAll("[^\\d]", "");

        List<String> nonNumbersList = Arrays.stream(encryptedMessageNonNumbers.split(""))
                .collect(Collectors.toList());
        List<Integer> numbersList = Arrays.stream(encryptedMessageNumbers.split(""))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int index = 0; index < numbersList.size(); index++) {
            if (index % 2 == 0) {
                takeList.add(numbersList.get(index));
            } else {
                skipList.add(numbersList.get(index));
            }
        }
        int fromIndex = 0;
        List<String> decryptedMessage = new ArrayList<>();
        for (int i = 0; i < takeList.size(); i++) {
            if (takeList.get(i)>0) {
                int toIndex = fromIndex + takeList.get(i);
                if (toIndex > nonNumbersList.size()) {
                    toIndex = nonNumbersList.size();
                }

            decryptedMessage.addAll(nonNumbersList.subList(fromIndex, toIndex ));
            }

            fromIndex += takeList.get(i) + skipList.get(i) ;

            if (fromIndex >= nonNumbersList.size()) {
                break;
            }

        }


        System.out.println(String.join("",decryptedMessage));

    }
}
