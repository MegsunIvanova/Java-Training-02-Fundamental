package theme07_AssociativeArrays.Exercises;

import java.util.*;

public class P03_MOBAChallenger_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, HashMap<String, Integer>> tier = new HashMap<>();

        String input = scanner.nextLine();
        //You will receive several input lines in one of the following formats:
        //"{player} -> {position} -> {skill}"
        //"{player} vs {player}"
        while (!input.equals("Season end")) {
            if (input.contains(" -> ")) {
                String player = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skill = Integer.parseInt(input.split(" -> ")[2]);
                //When you receive a player and his position and skill,
                // add him to the player pool, if he isn't present,
                // else add his position and skill
                // or update his skill, only if the current position skill is
                // lower than the new value.
                tier.putIfAbsent(player, new HashMap<>());
                tier.get(player).putIfAbsent(position, 0);
                if (tier.get(player).get(position) < skill) {
                    tier.get(player).put(position, skill);
                }
            } else if (input.contains(" vs ")) {
                String player1 = input.split(" vs ")[0];
                String player2 = input.split(" vs ")[1];
                //if both players exist in the tier, they duel
                if (tier.containsKey(player1) && tier.containsKey(player2)) {
                    //Compare their positions,
                    boolean isCommonPosition = false;
                    for (String positionPlayer1 : tier.get(player1).keySet()) {
                        if (tier.get(player2).keySet().contains(positionPlayer1)) {
                            isCommonPosition = true;
                            break;
                        }
                    }
                    // if they got at least one in common,
                    // the player with better total skill points wins
                    if (isCommonPosition) {
                        int player1TotalSkill = tier.get(player1).values().stream().mapToInt(d -> d).sum();
                        int player2TotalSkill = tier.get(player2).values().stream().mapToInt(d -> d).sum();
                        // and the other is demoted from the tier -> remove him.
                        if (player1TotalSkill > player2TotalSkill) {
                            tier.remove(player2);
                        } else if (player1TotalSkill < player2TotalSkill) {
                            tier.remove(player1);
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }
        Map<String, Integer> totalSkills = new HashMap<>();
        tier.entrySet().stream().forEach(player -> {
            int totalSkill = player.getValue().values().stream().mapToInt(d -> d).sum();
            totalSkills.put(player.getKey(), totalSkill);
        });

        totalSkills.entrySet().stream().sorted((player2, player1) -> {
            int sortBySkills = Integer.compare(player1.getValue(), player2.getValue());
            if (sortBySkills != 0) {
                return sortBySkills;
            } else {
                int sortByName = player2.getKey().compareTo(player1.getKey());
                return sortByName;
            }
        }).forEach(player -> {
            System.out.printf("%s: %d skill\n", player.getKey(), player.getValue());
            tier.get(player.getKey()).entrySet().stream().sorted((entry2, entry1) -> {
                int sortBySkillAtPosition = Integer.compare(entry1.getValue(), entry2.getValue());
                if (sortBySkillAtPosition != 0) {
                    return sortBySkillAtPosition;
                } else {
                    int sortByPosition = entry2.getKey().compareTo(entry1.getKey());
                    return sortByPosition;
                }
            }).forEach(entry -> {
                System.out.printf("- %s <::> %d\n", entry.getKey(), entry.getValue());
            });
        });

    }
}
