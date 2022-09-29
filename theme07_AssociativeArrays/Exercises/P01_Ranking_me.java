package theme07_AssociativeArrays.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Ranking_me {
    static class ResultFromContest {
        private String contest = "";
        private int points = 0;

        public ResultFromContest(String contest, int points) {
            this.contest = contest;
            this.points = points;
        }

        public String getContest() {
            return this.contest;
        }

        public int getPoints() {
            return this.points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        @Override
        public String toString() {
            return String.format("#  %s -> %d", contest, points);

        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //You will receive some lines of input in the format
        // "{contest}:{password for contest}"
        // until you receive "end of contests"
        //Save that data
        Map<String, String> contestsPass = new HashMap<>();
        String inputFirstPart = scanner.nextLine();
        while (!inputFirstPart.equals("end of contests")) {
            String contest = inputFirstPart.split(":")[0];
            String password = inputFirstPart.split(":")[1];
            contestsPass.put(contest, password);

            inputFirstPart = scanner.nextLine();
        }

        //After that, you will receive another type of inputs in the format
        // "{contest}=>{password}=>{username}=>{points}"
        // until you receive "end of submissions"

        Map<String, List<ResultFromContest>> contestsMap = new TreeMap<>();
        String inputSecondPart = scanner.nextLine();
        while (!inputSecondPart.equals("end of submissions")) {
            String contest = inputSecondPart.split("=>")[0];
            String password = inputSecondPart.split("=>")[1];
            String username = inputSecondPart.split("=>")[2];
            int points = Integer.parseInt(inputSecondPart.split("=>")[3]);
            if (contestsPass.containsKey(contest)) {
                if (contestsPass.get(contest).equals(password)) {
                    contestsMap.putIfAbsent(username, new ArrayList<>());
                    List<ResultFromContest> newResultList =
                            setResult(contestsMap.get(username), contest, points);
                    contestsMap.put(username, newResultList);
                }
            }


            inputSecondPart = scanner.nextLine();
        }

        Map<String, Integer> sumResults = new HashMap<>();
        for (Map.Entry<String, List<ResultFromContest>> entry : contestsMap.entrySet()) {
            int sum = 0;
            for (ResultFromContest currentResults : entry.getValue()) {
                sum += currentResults.getPoints();
            }
            sumResults.put(entry.getKey(), sum);
        }

        String candidateWithMaxResult = Collections.max(sumResults.entrySet(),
                Map.Entry.comparingByValue()).getKey();

        System.out.printf("Best candidate is %s with total %d points.\n"
                , candidateWithMaxResult, sumResults.get(candidateWithMaxResult));
        System.out.println("Ranking: ");
        contestsMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().stream().forEach(contest -> System.out.println(contest.toString()));
        });

    }

    private static List<ResultFromContest> setResult
            (List<ResultFromContest> currentResultsList, String contest, int points) {

        if (currentResultsList.isEmpty()) {
            currentResultsList.add(new ResultFromContest(contest, points));
        } else {
            boolean isUpdated = false;
            for (int i = 0; i < currentResultsList.size(); i++) {
                if (currentResultsList.get(i).getContest().equals(contest)) {
                    if (currentResultsList.get(i).getPoints() < points) {
                        currentResultsList.get(i).setPoints(points);
                    }
                    isUpdated = true;
                    currentResultsList.sort(Comparator.comparing(ResultFromContest::getPoints));
                    Collections.reverse(currentResultsList);
                    break;
                }
            }
            if (!isUpdated) {
                currentResultsList.add(new ResultFromContest(contest, points));
                currentResultsList.sort(Comparator.comparing(ResultFromContest::getPoints));
                Collections.reverse(currentResultsList);
            }

        }
        return currentResultsList;
    }
}
