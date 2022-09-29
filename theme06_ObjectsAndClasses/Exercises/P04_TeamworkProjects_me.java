package theme06_ObjectsAndClasses.Exercises;

import java.util.*;

public class P04_TeamworkProjects_me {
    static class Team {
        private String name;
        private String creator;
        private List<String> members;

        public Team(String name, String creator) {
            this.name = name;
            this.creator = creator;
            this.members = new ArrayList<>();
        }

        public String getName() {
            return this.name;
        }

        public String getCreator() {
            return this.creator;
        }

        public int getNumberOfMembers() {
            return members.size();
        }

        public List<String> getMembers() {
            return this.members;
        }

        public void addMember(String user) {
            this.members.add(user);
            Collections.sort(members);
        }

        private String membersToString() {
            String membersToString = "";
            for (String member : members) {
                membersToString += String.format("-- %s\n", member);
            }
            return membersToString;
        }

        public String toString() {
            if (!members.isEmpty()) {
                return String.format("%s\n" +
                        "- %s\n" +
                        "%s", this.name, this.creator, this.membersToString());
            }
            return this.name+"\n";

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Team> teamsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] dataOfTeam = scanner.nextLine().split("-");
            String creator = dataOfTeam[0];
            String teamName = dataOfTeam[1];
            if (isExistingTeam(teamsList, teamName)) {
                System.out.printf("Team %s was already created!\n", teamName);
            } else if (isCreatorUnique(teamsList, creator)) {
                System.out.printf("%s cannot create another team!\n", creator);
            } else {
                teamsList.add(new Team(teamName, creator));
                System.out.printf("Team %s has been created by %s!\n", teamName, creator);
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("end of assignment")) {
            String[] assignmentArr = input.split("->");
            String user = assignmentArr[0];
            String teamName = assignmentArr[1];
            if (!isExistingTeam(teamsList, teamName)) {
                System.out.printf("Team %s does not exist!\n", teamName);
            } else if (isUserAlreadyMemberOrCreator(teamsList, user)) {
                System.out.printf("Member %s cannot join team %s!\n", user, teamName);
            } else {
                getTeamByItsName(teamsList, teamName).addMember(user);
            }


            input = scanner.nextLine();
        }
        //sort first by number of members than by name
        Collections.sort(teamsList, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                Integer members1 = o1.getNumberOfMembers();
                Integer members2 = o2.getNumberOfMembers();
                int membersCompare = members2.compareTo(members1);

                if (membersCompare != 0) {
                    return membersCompare;
                }

                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareTo(name2);
            }
        });
        //print
        boolean flag = false;
        for (Team team : teamsList) {
            if (team.getNumberOfMembers() == 0 && !flag) {
                System.out.println("Teams to disband:");
                flag = true;
            }
            System.out.print(team.toString());
        }
        if (!flag) {
            System.out.println("Teams to disband:");
        }

    }

    private static boolean isExistingTeam
            (List<Team> teamsList, String teamName) {
        for (Team team : teamsList) {
            if (team.getName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCreatorUnique
            (List<Team> teamsList, String creator) {
        for (Team team : teamsList) {
            if (team.getCreator().equals(creator)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isUserAlreadyMemberOrCreator(List<Team> teamsList, String user) {
        for (Team team : teamsList) {
            if (team.getCreator().equals(user)) {
                return true;
            }
            for (String member : team.getMembers()) {
                if (member.equals(user)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Team getTeamByItsName(List<Team> teamsList, String teamName) {
        for (Team team : teamsList) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }

}
