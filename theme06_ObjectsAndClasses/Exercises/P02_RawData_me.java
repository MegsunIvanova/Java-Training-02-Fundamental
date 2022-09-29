package theme06_ObjectsAndClasses.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02_RawData_me {
    static class Car {
        //Car that holds information about the
        // model, engine, cargo, and a collection of exactly 4 tires
        private String model;
        private Engine engine;
        private Cargo cargo;
        private Tire[] tires = new Tire[4];

        public Car(String[] carData) {
            this.model = carData[0];
            this.engine = new Engine(Integer.parseInt(carData[1]), Integer.parseInt(carData[2]));
            this.cargo = new Cargo(Integer.parseInt(carData[3]), carData[4]);
            int carDataIndex = 5;
            for (int i = 0; i < this.tires.length; i++) {
                tires[i] = new Tire(Double.parseDouble(carData[carDataIndex]),
                        Integer.parseInt(carData[carDataIndex + 1]));
                carDataIndex += 2;
            }
        }

        public boolean isCarFragile() {
            if (this.cargo.getType().equals("fragile")) {
                for (int i = 0; i < this.tires.length; i++) {
                    double currentTyrePressure = this.tires[i].getPressure();
                    if (currentTyrePressure < 1) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isCarFlamable() {
            if (this.cargo.getType().equals("flamable")
                    && this.engine.getPower() > 250) {
                return true;
            }
            return false;
        }

        public String getModel() {
            return this.model;
        }

    }

    static class Engine {
        private int speed;
        private int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return this.power;
        }
    }

    static class Cargo {
        private int weight;
        private String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

    }

    static class Tire {
        private double pressure;
        private int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return this.pressure;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] carDataArr = scanner.nextLine().split(" ");
            Car currentCar = new Car(carDataArr);
            carsList.add(currentCar);
        }

        String input = scanner.nextLine();

        if (input.equals("fragile")) {
            for (Car currentCar : carsList) {
                if (currentCar.isCarFragile()) {
                    System.out.println(currentCar.getModel());
                }
            }

        } else if (input.equals("flamable")) {
            for (Car currentCar : carsList) {
                if (currentCar.isCarFlamable()) {
                    System.out.println(currentCar.getModel());
                }
            }

        }

    }


}
