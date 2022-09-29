package theme07_AssociativeArrays.Exercises;

import java.util.*;

public class P07_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> studentsGradesMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            String grade = scanner.nextLine();
            studentsGradesMap.putIfAbsent(student, new ArrayList<>());
            studentsGradesMap.get(student).add(grade);
        }

        Map<String, Double> studentAverageGradesMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : studentsGradesMap.entrySet()) {
            double averageGrade = entry.getValue().stream()
                    .mapToDouble(Double::parseDouble).average().getAsDouble();
            if (averageGrade >= 4.5) {
                studentAverageGradesMap.put(entry.getKey(), averageGrade);
            }
        }

        for (Map.Entry<String, Double> entry : studentAverageGradesMap.entrySet()) {
            System.out.printf("%s -> %.2f\n", entry.getKey(), entry.getValue());
        }

    }
}
