package theme07_AssociativeArrays.Lab;

import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {

        HashMap<String, Integer> airplanes = new HashMap<>();
        airplanes.put("Boeing 737", 130);
        airplanes.put("Airbus A320", 150);
        airplanes.remove("Boeing 737");

        if (airplanes.containsKey("Airbus A320")) {
            System.out.println("Airbus A320 key exists");
        }

        System.out.println(airplanes.containsValue(150));
        System.out.println(airplanes.containsValue(100));
    }
}
