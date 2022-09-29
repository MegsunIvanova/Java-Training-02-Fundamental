package FinalExam_Practice;

import java.util.*;

public class P03_HeroesOfCodeAndLogicVII_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();
        //Map <heroName, List {heroHP, heroMP}>

        //създаване на речник с героите и техните точки
        for (int i = 0; i < numberOfHeroes; i++) {
            String[] heroArr = scanner.nextLine().split(" ");
            String heroName = heroArr[0];
            int heroHP = Integer.parseInt(heroArr[1]);
            int heroMP = Integer.parseInt(heroArr[2]);
            List<Integer> heroPointsList = new ArrayList<>();
            //List {heroHP, heroMP}
            heroPointsList.add(heroHP);
            heroPointsList.add(heroMP);
            heroesMap.putIfAbsent(heroName, heroPointsList);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];
            int heroHP = heroesMap.get(heroName).get(0);
            int heroMP = heroesMap.get(heroName).get(1);
            int amount = 0;
            switch (command) {
                case "CastSpell":
                    //"CastSpell – {hero name} – {MP needed} – {spell name}"
                    int neededMP = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if (heroMP >= neededMP) {
                        //he cast the spell
                        int leftMP = heroMP - neededMP;
                        heroesMap.get(heroName).set(1, leftMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                                heroName, spellName, leftMP);
                    } else {
                        //hero is unable to cast the spell
                        System.out.printf("%s does not have enough MP to cast %s!\n",
                                heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    //"TakeDamage – {hero name} – {damage} – {attacker}"
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    //Reduce the hero HP by the given damage amount.
                    heroHP -= damage;
                    if (heroHP > 0) {
                        //hero is still alive
                        heroesMap.get(heroName).set(0, heroHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                                heroName, damage, attacker, heroHP);
                    } else {
                        //hero has died
                        heroesMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!\n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    //"Recharge – {hero name} – {amount}"
                    amount = Integer.parseInt(tokens[2]);
                    int rechargedHeroMP = heroMP + amount;
                    if (rechargedHeroMP > 200) {
                        rechargedHeroMP = 200;
                    }
                    heroesMap.get(heroName).set(1, rechargedHeroMP);
                    System.out.printf("%s recharged for %d MP!\n",
                            heroName, rechargedHeroMP - heroMP);
                    break;
                case "Heal":
                    //"Heal – {hero name} – {amount}"
                    amount = Integer.parseInt(tokens[2]);
                    int healedHeroHP = heroHP + amount;
                    if (healedHeroHP > 100) {
                        healedHeroHP = 100;
                    }
                    heroesMap.get(heroName).set(0, healedHeroHP);
                    System.out.printf("%s healed for %d HP!\n",
                            heroName, healedHeroHP - heroHP);
                    break;
            }

            input = scanner.nextLine();
        }

        heroesMap.entrySet().forEach(entry -> {
            String heroName = entry.getKey();
            int heroHP = entry.getValue().get(0);
            int heroMP = entry.getValue().get(1);
            System.out.println(heroName);
            System.out.println("  HP: "+heroHP);
            System.out.println("  MP: "+heroMP);
        });

    }
}
