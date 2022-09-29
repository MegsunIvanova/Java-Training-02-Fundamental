package FinalExam_Practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());//n – the number of heroes that you can choose for your party

        Map<String, Integer> heroesHP = new LinkedHashMap<>();
        Map<String, Integer> heroesMP = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            //"{hero name} {HP} {MP}"
            String[] heroData = scanner.nextLine().split(" ");
            String heroName = heroData[0];
            int hitPoints = Integer.parseInt(heroData[1]);
            int manaPoints = Integer.parseInt(heroData[2]);
            //a hero can have a maximum of 100 HP and 200 MP
            //the starting HP/MP of the heroes will be valid
            heroesHP.putIfAbsent(heroName, hitPoints);
            heroesMP.putIfAbsent(heroName, manaPoints);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];
            switch (command) {
                //"CastSpell – {hero name} – {MP needed} – {spell name}"
                case "CastSpell":
                    int neededMP = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    castSpell(heroesMP, heroName, neededMP, spellName);
                    break;
                //"TakeDamage – {hero name} – {damage} – {attacker}"
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    takeDamage(heroesHP, heroesMP, heroName, damage, attacker);
                    break;
                //"Recharge – {hero name} – {amount}"
                case "Recharge":
                    int amountOfRecharge = Integer.parseInt(tokens[2]);
                    recharge(heroesMP, heroName, amountOfRecharge);
                    break;
                //"Heal – {hero name} – {amount}"
                case "Heal":
                    int amountOfHeal = Integer.parseInt(tokens[2]);
                    heal(heroesHP, heroName, amountOfHeal);
                    break;
            }
            input = scanner.nextLine();
        }

        if (!heroesHP.isEmpty()) {
            heroesHP.entrySet().forEach(hero -> {
                System.out.println(hero.getKey());
                System.out.println("  HP: " + hero.getValue());
                System.out.println("  MP: " + heroesMP.get(hero.getKey()));
            });
        }
    }

    private static void castSpell
            (Map<String, Integer> heroesMP,
             String heroName, int neededMP, String spellName) {
        int heroMP = heroesMP.get(heroName);
        //•	If the hero has the required MP, he casts the spell
        if (heroMP >= neededMP) {
            //reducing his MP
            int currentMP = heroesMP.get(heroName);
            heroesMP.put(heroName, currentMP - neededMP);
            System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                    heroName, spellName, heroesMP.get(heroName));
        } //•	If the hero is unable to cast the spell
        else {
            System.out.printf("%s does not have enough MP to cast %s!\n",
                    heroName, spellName);
        }
    }

    private static void takeDamage
            (Map<String, Integer> heroesHP, Map<String, Integer> heroesMP,
             String heroName, int damage, String attacker) {
        int currentHP = heroesHP.get(heroName);
        //•	Reduce the hero HP by the given damage amount
        heroesHP.put(heroName, currentHP - damage);
        if (heroesHP.get(heroName) > 0) { //If the hero is still alive
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                    heroName, damage, attacker, heroesHP.get(heroName));
        } else { //If the hero has died, remove him from your party
            heroesHP.remove(heroName);
            heroesMP.remove(heroName);
            System.out.printf("%s has been killed by %s!\n",
                    heroName, attacker);
        }
    }

    private static void recharge(Map<String, Integer> heroesMP, String heroName, int amount) {
        //•	The hero increases his MP (the MP can't go over the maximum value 200)
        int heroMP = heroesMP.get(heroName);
        if (heroMP + amount > 200) {
            heroesMP.put(heroName, 200);
            amount = 200 - heroMP;
        } else {
            heroesMP.put(heroName, heroMP + amount);
        }
        System.out.printf("%s recharged for %d MP!\n",
                heroName, amount);
    }

    private static void heal(Map<String, Integer> heroesHP, String heroName, int amount) {
        //The hero increases his HP (the HP can't go over the maximum value 100)
        int heroHP = heroesHP.get(heroName);
        if (heroHP + amount > 100) {
            heroesHP.put(heroName, 100);
            amount = 100 - heroHP;
        } else {
            heroesHP.put(heroName, heroHP + amount);
        }
        System.out.printf("%s healed for %d HP!\n",
                heroName, amount);
    }
}

