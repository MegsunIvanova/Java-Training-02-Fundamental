package theme05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08_AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> texts = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            //•	merge {startIndex} {endIndex}
            //•	divide {index} {partitions}
            if (command.contains("merge")) {
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[2]);
                //проверка за startIndex
                if (startIndex < 0) {
                    startIndex = 0;
                }
                //проверка за endIndex
                if (endIndex > texts.size() - 1) {
                    endIndex = texts.size() - 1;
                }
                //валидираме индексите
                boolean isValidIndexes = startIndex < texts.size() && endIndex >= 0
                        && endIndex > startIndex;
                if (isValidIndexes) {
                    //merge
                    String resultMerge = "";
                    for (int i = startIndex; i <= endIndex; i++) {
                        resultMerge += texts.get(i);
                    }
                    //remove old elements
                    for (int i = startIndex; i <= endIndex; i++) {
                        texts.remove(startIndex);
                    }
                    texts.add(startIndex, resultMerge);

                }
            } else if (command.contains("divide")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int parts = Integer.parseInt(command.split(" ")[2]);

                String elementForDivide = texts.get(index);
                texts.remove(index);

                //колко елемента ще има всяка една част
                int partSize = elementForDivide.length() / parts;
                int beginIndexOfText = 0;
                for (int part = 1; part < parts; part++) {
                    texts.add(index, elementForDivide
                            .substring(beginIndexOfText, beginIndexOfText + partSize));
                    index++;
                    beginIndexOfText += partSize;
                }
                //добавяме останалите символи към последната част
                texts.add(index, elementForDivide
                        .substring(beginIndexOfText));
                //ako не зададем краен индекс на събстринга взема до края
            }

            command = scanner.nextLine();
        }


        //печатане на списък с текстове
        System.out.println(String.join(" ", texts ));

    }
}
