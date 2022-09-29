package FinalExam_Practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            cars.put(car, new int[]{mileage, fuel});
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] commands = input.split(" : ");
            String command = commands[0];
            String car = commands[1];
            switch (command) {
                //•	"Drive : {car} : {distance} : {fuel}"
                //•	"Refuel : {car} : {fuel}"
                //•	"Revert : {car} : {kilometers}"
                case "Drive":

                    int distance = Integer.parseInt(commands[2]);
                    int neededFuel = Integer.parseInt(commands[3]);
                    driveTheGivenDistance(cars, car, distance, neededFuel);
                    break;
                case "Refuel":
                    int givenFuel = Integer.parseInt(commands[2]);
                    refuelCarTank(cars, car, givenFuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commands[2]);
                    decreaseCarMileageWithKilometers(cars, car, kilometers);
                    break;
            }
            input = scanner.nextLine();
        }
        cars.entrySet().forEach(car -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                    car.getKey(), car.getValue()[0], car.getValue()[1]);
        });
    }

    private static void driveTheGivenDistance
            (Map<String, int[]> cars, String car, int distance, int neededFuel) {
        //o	You need to drive the given distance,
        // and you will need the given fuel to do that.
        int carMileage = cars.get(car)[0];
        int carFuel = cars.get(car)[1];
        if (carFuel < neededFuel) { //If the car doesn't have enough fuel:
            System.out.println("Not enough fuel to make that ride");
        } else { //If the car has the required fuel available in the tank:
            carFuel -= neededFuel;
            carMileage += distance;
            cars.put(car, new int[]{carMileage, carFuel});
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n"
                    , car, distance, neededFuel);
        }
        //if a car's mileage reaches 100 000 km, remove it from the collection
        if (carMileage >= 100000) {
            cars.remove(car);
            System.out.printf("Time to sell the %s!\n", car);
        }
    }

    private static void refuelCarTank(Map<String, int[]> cars, String car, int givenFuel) {
        //Refill the tank of your car (Each tank can hold a maximum of 75 liters of fuel)
        int carFuel = cars.get(car)[1];
        int fuelLoaded = givenFuel;
        if (carFuel + givenFuel > 75) {
            fuelLoaded = 75 - carFuel;
        }
        cars.get(car)[1] = carFuel + fuelLoaded;
        System.out.printf("%s refueled with %d liters\n", car, fuelLoaded);
    }

    private static void decreaseCarMileageWithKilometers(Map<String, int[]> cars, String car, int kilometers) {
        int carMileage = cars.get(car)[0];
        //o	Decrease the mileage of the given car with the given kilometers
        if (carMileage - kilometers >= 10000) {
            cars.get(car)[0] = carMileage - kilometers;
            System.out.printf("%s mileage decreased by %d kilometers\n", car, kilometers);
        } else if (carMileage > 10000) { //o	If the mileage becomes less than 10 000km after it is decreased, just set it to 10 000km
            cars.get(car)[0] = 10000;
        }
    }
}
