package theme07_AssociativeArrays.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //You will be receiving lines in the following format:
        // "{username}-{language}-{points}"
        // until you receive "exam finished"
        Map<String, Integer> resultsByUsersMap = new LinkedHashMap<>();
        Map<String, Integer> countByLanguageMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String username = input.split("-")[0];
            if (!input.split("-")[1].equals("banned")) {
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);

                resultsByUsersMap.putIfAbsent(username, 0);
                if (resultsByUsersMap.get(username) < points) {
                    resultsByUsersMap.put(username, points);
                }

                countByLanguageMap.putIfAbsent(language, 0);
                countByLanguageMap.put(language, countByLanguageMap.get(language) + 1);

            } else {
                //You can receive a command to ban a user for cheating in the following format:
                // "{username}-banned"
                //you should remove the user from the contest
                // but preserve his submissions in the total count of submissions for each language
                resultsByUsersMap.remove(username);
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        resultsByUsersMap.entrySet().forEach(entry -> System.out.printf("%s | %d\n", entry.getKey(), entry.getValue()));
        System.out.println("Submissions:");
        countByLanguageMap.entrySet().forEach(entry -> System.out.printf("%s - %d\n", entry.getKey(), entry.getValue()));
    }
}
