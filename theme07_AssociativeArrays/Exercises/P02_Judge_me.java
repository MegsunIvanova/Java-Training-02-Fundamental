package theme07_AssociativeArrays.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class P02_Judge_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"{username} -> {contest} -> {points}"
        //You should end your program when you receive the command "no more time"
        Map<String, LinkedHashMap<String, Integer>> contestMap = new LinkedHashMap<>();

        String input = scanner.nextLine();


        while (!input.equals("no more time")) {
            String username = input.split(" -> ")[0];
            String contestName = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);
            //check if such a contest already exists, and if not, add it
            contestMap.putIfAbsent(contestName, new LinkedHashMap<>());
            //check if such a contest already exists, and if not, add it
            //if he is participating take the higher score, otherwise, just add it
            contestMap.get(contestName).putIfAbsent(username, 0);
            if (contestMap.get(contestName).get(username) < points) {
                contestMap.get(contestName).put(username, points);
            }
            input = scanner.nextLine();
        }

        //you should print each contest in order of input,
        // for each contest print the participants ordered by points in descending order,
        // then ordered by name in ascending order
        //•	The output format for the contests is:
        //"{constestName}: {participants.Count} participants
        //{position}. {username} <::> {points}"
        AtomicInteger num = new AtomicInteger();

        contestMap.entrySet().stream().forEach(contest -> {
            num.set(1);
            System.out.printf("%s: %d participants\n", contest.getKey(), contest.getValue().size());
            contest.getValue().entrySet().stream().sorted((participant2, participant1) -> {
                int sortByPointResult = Integer.compare(participant1.getValue(), participant2.getValue());
                if (sortByPointResult != 0) {
                    return sortByPointResult;
                } else {
                    int sortByName = participant2.getKey().compareTo(participant1.getKey());
                    return sortByName;
                }
            }).forEach(participant -> {
                System.out.printf("%d. %s <::> %d\n", num.getAndIncrement(), participant.getKey(), participant.getValue());
            });
        });
        // After that, you should print individual statistics
        // for every participant ordered by total points in descending order,
        // and then by alphabetical order
        //The output format is:
        //"Individual standings:
        //{position}. {username} -> {totalPoints}"
        Map<String, Integer> standingsMap = new LinkedHashMap<>();

        contestMap.entrySet().stream().forEach(contest -> {
            contest.getValue().entrySet().stream().forEach(participant -> {
                        String username = participant.getKey();
                        int points = participant.getValue();
                        standingsMap.putIfAbsent(username, 0);
                        standingsMap.put(username, standingsMap.get(username) + points);
                    }
            );
        });
        System.out.println("Individual standings:");
        num.set(1);
        standingsMap.entrySet().stream().sorted((participant2, participant1) -> {
            int sortByPointResult = Integer.compare(participant1.getValue(), participant2.getValue());
            if (sortByPointResult != 0) {
                return sortByPointResult;
            } else {
                int sortByName = participant2.getKey().compareTo(participant1.getKey());
                return sortByName;
            }
        }).forEach(participant -> {
            System.out.printf("%d. %s -> %d\n",
                    num.getAndIncrement(), participant.getKey(), participant.getValue());
        });
    }
}
