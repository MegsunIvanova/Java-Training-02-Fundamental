package theme06_ObjectsAndClasses.Exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P03_CarSalesman_me {
    static class Car {
        String modelOfCar;
        Engine engine;
        String weight; //optional
        String color; //optional

        public Car(String[] carData, List<Engine> enginesList) {
            //"{Model} {EngineModel} {Weight} {Color}"
            this.modelOfCar = carData[0];
            this.engine = getEngineByModel(enginesList, carData[1]);
            this.weight = "n/a";
            this.color = "n/a";
            if (carData.length >= 3) {
                if (carData[2].matches("\\d+")) {
                    this.weight = carData[2];
                } else {
                    this.color = carData[2];
                }
            }
            if (carData.length == 4) {
                this.color = carData[3];
            }
        }

        //"{CarModel}:
        //  {EngineModel}:
        //    Power: {EnginePower}
        //    Displacement: {EngineDisplacement}
        //    Efficiency: {EngineEfficiency}
        //  Weight: {CarWeight}
        //  Color: {CarColor}"
        public String toString() {
            return String.format("%s:\n" +
                            "  %s:\n" +
                            "    Power: %s\n" +
                            "    Displacement: %s\n" +
                            "    Efficiency: %s\n" +
                            "  Weight: %s\n" +
                            "  Color: %s",
                    this.modelOfCar, this.engine.getModelOfEngine(),
                    this.engine.getPower(), this.engine.getDisplacement(),
                    this.engine.getEfficiency(), this.weight, this.color);
        }
    }

    static class Engine {
        private String modelOfEngine;
        private String power;
        private String displacement; //optional
        private String efficiency; //optional

        public Engine(String[] engineData) {
            //"{Model} {Power} {Displacement} {Efficiency}"
            this.modelOfEngine = engineData[0];
            this.power = engineData[1];
            this.displacement = "n/a";
            this.efficiency = "n/a";
            if (engineData.length >= 3) {
                if (engineData[2].matches("\\d+")) {
                    this.displacement = engineData[2];
                } else {
                    this.efficiency = engineData[2];
                }
            }
            if (engineData.length == 4) {
                this.efficiency = engineData[3];
            }
        }

        public String getModelOfEngine() {
            return this.modelOfEngine;
        }

        public String getPower() {
            return this.power;
        }

        public String getDisplacement() {
            return this.displacement;
        }

        public String getEfficiency() {
            return this.efficiency;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> enginesList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            //"{Model} {Power} {Displacement} {Efficiency}"
            String[] engineData = scanner.nextLine().split(" ");
            Engine engine = new Engine(engineData);
            enginesList.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            String[] carData = scanner.nextLine().split(" ");
            Car car = new Car(carData, enginesList);
            carsList.add(car);
        }

        for (Car car : carsList) {
            System.out.println(car.toString());
        }


    }

    private static Engine getEngineByModel(List<Engine> enginesList, String modelOfEngine) {
        for (Engine engine : enginesList) {
            if (engine.getModelOfEngine().equals(modelOfEngine)) {
                return engine;
            }
        }
        return null;
    }
}
