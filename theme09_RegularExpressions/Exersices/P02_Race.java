package theme09_RegularExpressions.Exersices;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();
        List<String> racersList = Arrays.stream(names.split(", ")).collect(Collectors.toList());//Списък с имената на съзтезателите
        //съзтезател -> дистанция
        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        racersList.forEach(name -> racersDistances.put(name, 0));

        //Regex
        String regexLetters = "[A-Za-z]+";
        Pattern patternLetters = Pattern.compile(regexLetters);

        String regexDigit = "[0-9]";
        Pattern patternDigit = Pattern.compile(regexDigit);

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            //input -> G4e@55or%6g6!68e!!@
            //име на съзтезателя -> само от буквите
            StringBuilder nameBuilder = new StringBuilder();
            Matcher matcherLetters = patternLetters.matcher(input);
            while (matcherLetters.find()) {
                nameBuilder.append(matcherLetters.group());
            }

            //дистанция -> сума на числата
            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input);
            while (matcherDigit.find()) {
                distance += Integer.parseInt(matcherDigit.group());
            }

            //добавя дистанцията на определения съзтезател
            String racerName = nameBuilder.toString();
            if (racersDistances.containsKey(racerName)) {
                int currentDistance = racersDistances.get(racerName);
                racersDistances.put(racerName, currentDistance + distance);
            }
            input = scanner.nextLine();
        }
        
        //съзтезател -> дистаниця
        List<String> nameOfFirstThree = racersDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // сортиране на записите по value (дистанцията) в намаляващ ред
                .limit(3) // взима първите три записа от map
                .map(entry -> entry.getKey()) //на всеки запис вземам ключа (името на играча)
                .collect(Collectors.toList()); //получавам List от първите трима играча

        System.out.println("1st place: "+ nameOfFirstThree.get(0));
        System.out.println("2nd place: "+ nameOfFirstThree.get(1));
        System.out.println("3rd place: "+ nameOfFirstThree.get(2));

    }
}
