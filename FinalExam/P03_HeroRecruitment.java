package FinalExam;

import java.util.*;

public class P03_HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroesMap = new LinkedHashMap<>();
        //heroesMap <heroName, List <spell1, spell2>>

        String inputLine = scanner.nextLine();

        //receiving commands
        while (!inputLine.equals("End")) {
            String command = inputLine.split(" ")[0];
            String heroName = inputLine.split(" ")[1];
            String spellName = "";
            switch (command) {
                case "Enroll":
                    //o	"Enroll {HeroName}"
                    if (heroesMap.containsKey(heroName)) {
                        //if hero  exist
                        System.out.println(heroName + " is already enrolled.");
                    } else {
                        //add hero to collection
                        heroesMap.put(heroName, new ArrayList<>());
                    }
                    break;
                case "Learn":
                    //o	"Learn {HeroName} {SpellName}"
                    spellName = inputLine.split(" ")[2];
                    if (!heroesMap.containsKey(heroName)) {
                        //if hero does not exist
                        System.out.println(heroName + " doesn't exist.");
                    } else {
                        //if hero exist
                        List<String> heroSpellList = heroesMap.get(heroName);
                        if (heroSpellList.contains(spellName)) {
                            //hero already learn the spell
                            System.out.printf("%s has already learnt %s.\n",
                                    heroName, spellName);
                        } else {
                            //add spell
                            heroSpellList.add(spellName);
                            heroesMap.put(heroName, heroSpellList);
                        }
                    }
                    break;
                case "Unlearn":
                    //o	"Unlearn {HeroName} {SpellName}"
                    spellName = inputLine.split(" ")[2];
                    if (!heroesMap.containsKey(heroName)) {
                        //if hero does not exist
                        System.out.println(heroName + " doesn't exist.");
                    } else {
                        //if hero exist
                        List<String> heroSpellList = heroesMap.get(heroName);
                        if (!heroSpellList.contains(spellName)) {
                            //hero doesn't know the spell
                            System.out.printf("%s doesn't know %s.\n",
                                    heroName, spellName);
                        } else {
                            //remove spell
                            heroSpellList.remove(spellName);
                            heroesMap.put(heroName, heroSpellList);
                        }
                    }
                    break;
            }
            inputLine = scanner.nextLine();
        }

        System.out.println("Heroes:");
        heroesMap.entrySet().forEach(entry -> {
            String heroName = entry.getKey();
            String heroSpells = "";
            if (entry.getValue().size() > 0) {
                heroSpells = " " + String.join(", ", entry.getValue());
            }

            System.out.printf("== %s:%s\n", heroName, heroSpells);
        });

    }
}
