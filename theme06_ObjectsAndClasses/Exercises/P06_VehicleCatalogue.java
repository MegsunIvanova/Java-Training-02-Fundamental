package theme06_ObjectsAndClasses.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06_VehicleCatalogue {
    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            String firstLetter = "" + type.charAt(0);
            this.type = firstLetter.toUpperCase() + type.substring(1);
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String toString() {
            return "Type: " + this.type + "\n"
                    + "Model: " + this.model + "\n"
                    + "Color: " + this.color + "\n"
                    + "Horsepower: " + this.horsepower + "\n";
        }

        public int getHorsepower() {
            return this.horsepower;
        }

        public String getType() {
            return this.type;
        }

        public String getModel() {
            return this.model;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        List<Vehicle> vehiclesList = new ArrayList<>();

        while (!inputLine.equals("End")) {
            String[] currentVehicleData = inputLine.split(" ");

            String type = currentVehicleData[0];
            String model = currentVehicleData[1];
            String color = currentVehicleData[2];
            int horsepower = Integer.parseInt(currentVehicleData[3]);
            Vehicle currentVehicle = new Vehicle(type, model, color, horsepower);

            vehiclesList.add(currentVehicle);

            inputLine = scanner.nextLine();
        }

        String models = scanner.nextLine();

        while (!models.equals("Close the Catalogue")) {
            System.out.print(getVehicleByModel(vehiclesList, models).toString());
            models = scanner.nextLine();
        }

        System.out.printf("Cars have average horsepower of: %.2f.\n",
                getAverageHorsepowerByVehicleType(vehiclesList, "Car"));
        System.out.printf("Trucks have average horsepower of: %.2f.",
                getAverageHorsepowerByVehicleType(vehiclesList, "Truck"));

    }

    private static Vehicle getVehicleByModel(List<Vehicle> vehiclesList, String model) {
        for (Vehicle currentVehicle : vehiclesList) {
            if (currentVehicle.getModel().equals(model)) {
                return currentVehicle;
            }
        }
        return null;
    }

    private static double getAverageHorsepowerByVehicleType
            (List<Vehicle> vehiclesList, String type) {
        int totalHorsepower = 0;
        int count = 0;
        for (Vehicle currentVehicle : vehiclesList) {
            if (currentVehicle.getType().equals(type)) {
                totalHorsepower += currentVehicle.getHorsepower();
                count++;
            }
        }
        double averageHorsepower = 0.0;
        if (count > 0) {
            averageHorsepower = totalHorsepower * 1.0 / count;
        }
        return averageHorsepower;
    }
}
