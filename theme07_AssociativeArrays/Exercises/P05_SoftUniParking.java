package theme07_AssociativeArrays.Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingRegister = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            //•	"register {username} {licensePlateNumber}"
            //•	"unregister {username}"
            String command = input.split(" ")[0];
            String username = input.split(" ")[1];
            if (command.equals("register")) {
                String licensePlateNumber = input.split(" ")[2];
                if (parkingRegister.containsKey(username)) {
                    System.out.printf("ERROR: already registered with plate number %s\n", parkingRegister.get(username));
                } else {
                    parkingRegister.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully\n", username, parkingRegister.get(username));
                }

            } else if (command.equals("unregister")) {
                if (!parkingRegister.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found\n", username);
                } else {
                    parkingRegister.remove(username);
                    System.out.printf("%s unregistered successfully\n", username);
                }
            }
        }
        for (Map.Entry<String, String> entry : parkingRegister.entrySet()) {
            System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
        }

    }
}
