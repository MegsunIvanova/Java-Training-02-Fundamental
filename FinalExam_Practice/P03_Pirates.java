package FinalExam_Practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Map <Град,Популация> targetTownsPopulation
        //Map <Град,Злато> targetTownsGold
        Map<String, Integer> targetsPopulation = new LinkedHashMap<>();
        Map<String, Integer> targetsGold = new LinkedHashMap<>();

        String target = scanner.nextLine();
        while (!target.equals("Sail")) {
            String[] tokens = target.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            //•	If you receive a city that has already been received,
            // you have to increase the population and gold with the given values
            targetsPopulation.putIfAbsent(city, 0);
            targetsGold.putIfAbsent(city, 0);
            int currentPopulation = targetsPopulation.get(city);
            int currentGold = targetsGold.get(city);
            targetsPopulation.put(city, currentPopulation + population);
            targetsGold.put(city, currentGold + gold);

            target = scanner.nextLine();
        }

        String event = scanner.nextLine();
        while (!event.equals("End")) {
            String[] tokens = event.split("=>");

            String command = tokens[0];
            String city = tokens[1];
            if (command.equals("Plunder")) {  //•	"Prosper=>{town}=>{gold}"
                int peopleKilled = Integer.parseInt(tokens[2]);
                int goldStolen = Integer.parseInt(tokens[3]);
                plunderTown(city, peopleKilled, goldStolen, targetsPopulation, targetsGold);

            } else if (command.equals("Prosper")) {      //•	"Plunder=>{town}=>{people}=>{gold}"
                int gold = Integer.parseInt(tokens[2]);
                townProsper(city, gold, targetsGold);
            }

            event = scanner.nextLine();
        }

        if (targetsGold.size() > 0) {
            int targetsNumber = targetsGold.size();
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", targetsNumber);
            targetsPopulation.entrySet().forEach(e -> {
                String city = e.getKey();
                int population = e.getValue();
                int gold = targetsGold.get(city);
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", city, population, gold);
            });

        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }

    private static void plunderTown(String city, int peopleKilled, int goldStolen,
                                    Map<String, Integer> targetsPopulation,
                                    Map<String, Integer> targetsGold) {
        //successfully attacked and plundered the town
        //killing the given number of people and
        // stealing the respective amount of gold
        if (peopleKilled < 0) {
            peopleKilled = 0;
        }
        if (goldStolen < 0) {
            goldStolen = 0;
        }
        int currentPopulation = targetsPopulation.get(city);
        int currentGold = targetsGold.get(city);
        boolean isTownDisbanded = false;
        if (peopleKilled >= currentPopulation) {
            peopleKilled = currentPopulation;
            isTownDisbanded = true;
        }
        if (goldStolen >= currentGold) {
            goldStolen = currentGold;
            isTownDisbanded = true;
        }
        targetsPopulation.put(city, currentPopulation - peopleKilled);
        targetsGold.put(city, currentGold - goldStolen);
        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",
                city, goldStolen, peopleKilled);
        if (isTownDisbanded) {
            targetsPopulation.remove(city);
            targetsGold.remove(city);
            System.out.println(city + " has been wiped off the map!");
        }
    }

    private static void townProsper(String city, int gold,
                                    Map<String, Integer> targetsGold) {
        // increasing its treasury by the given amount of gold.
        //o	The gold amount can be a negative number, so be careful
        if (gold < 0) {
            System.out.println("Gold added cannot be a negative number!");
        } else {
            int currentGold = targetsGold.get(city);
            targetsGold.put(city, currentGold + gold);
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",
                    gold, city, (currentGold + gold));
        }
    }

}

