package FinalExam_Practice;

import java.util.*;

public class P03_NeedForSpeedIII_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();//key -> car, value -> List {mileage, fuel}
        for (int i = 0; i < n; i++) {
            String[] carsToken = scanner.nextLine().split("\\|");
            String car = carsToken[0];
            int mileage = Integer.parseInt(carsToken[1]);
            int fuel = Integer.parseInt(carsToken[2]);
            carsMap.putIfAbsent(car, new ArrayList<>());
            carsMap.get(car).add(mileage);
            carsMap.get(car).add(fuel);
        }

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Stop")) {
            String[] tokens = inputLine.split(" : ");
            String command = tokens[0];
            String car = tokens[1];
            int mileage = carsMap.get(car).get(0);
            int fuel = carsMap.get(car).get(1);

            switch (command) {
                //•	"Drive : {car} : {distance} : {fuel}"
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int consumedFuel = Integer.parseInt(tokens[3]);
                    //o	You need to drive the given distance,
                    // and you will need the given fuel to do that.

                    if (fuel >= consumedFuel) { //If the car has the required fuel available in the tank:
                        carsMap.get(car).set(0, mileage + distance);
                        carsMap.get(car).set(1, fuel - consumedFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n"
                                , car, distance, consumedFuel);
                    } else { //If the car doesn't have enough fuel:
                        System.out.println("Not enough fuel to make that ride");
                    }
                    //if a car's mileage reaches 100 000 km, remove it from the collection
                    if (carsMap.get(car).get(0) >= 100000) {
                        carsMap.remove(car);
                        System.out.printf("Time to sell the %s!\n", car);
                    }
                    break;

                //•	"Refuel : {car} : {fuel}"
                case "Refuel":
                    int refillFuel = Integer.parseInt(tokens[2]);
                    //Refill the tank of your car (Each tank can hold a maximum of 75 liters of fuel)
                    int totalFuel = fuel + refillFuel;
                    int diff = refillFuel;
                    if (totalFuel > 75) {
                        diff = 75 - fuel;
                        totalFuel = 75;
                    }
                    carsMap.get(car).set(1, totalFuel);
                    System.out.printf("%s refueled with %d liters\n", car, diff);
                    break;

                //•	"Revert : {car} : {kilometers}"
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    //o	Decrease the mileage of the given car with the given kilometers
                    int totalMileage = mileage - kilometers;
                    if (totalMileage < 10000) {
                        //o	If the mileage becomes less than 10 000km after it is decreased, just set it to 10 000km
                        totalMileage = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers\n", car, kilometers);
                    }
                    carsMap.get(car).set(0, totalMileage);
                    break;
            }

            inputLine = scanner.nextLine();
        }

        carsMap.forEach((key, value) ->
                System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                        key, value.get(0), value.get(1)));
    }

}
