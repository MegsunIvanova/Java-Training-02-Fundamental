package theme07_AssociativeArrays.Exercises;

import java.util.*;

public class P08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companiesEmployeesMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String employeeId = input.split(" -> ")[1];
            companiesEmployeesMap.putIfAbsent(company, new ArrayList<>());
            if (!companiesEmployeesMap.get(company).contains(employeeId)) {
                companiesEmployeesMap.get(company).add(employeeId);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companiesEmployeesMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("-- " + String.join("\n-- ", entry.getValue()));
        }

    }
}
