package theme07_AssociativeArrays.Exercises;

import java.util.*;

public class P06_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> coursesMap = new LinkedHashMap<>();
        //•	Until you receive "end",
        // the input come in the format: "{courseName} : {studentName}".
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String courseName = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];
            coursesMap.putIfAbsent(courseName, new ArrayList<>());
            coursesMap.get(courseName).add(studentName);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue().size());
            System.out.println("-- " + String.join("\n-- ", entry.getValue()));
        }

    }
}
