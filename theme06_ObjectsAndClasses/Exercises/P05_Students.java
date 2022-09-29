package theme06_ObjectsAndClasses.Exercises;

import java.util.*;


public class P05_Students {
    static class Student {
        private String firstName;
        private String secondName;
        private double grade;

        public Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        public String toString() {
            return String.format("%s %s: %.2f", this.firstName, this.secondName, this.grade);
        }

        public double getGrade() {
            return this.grade;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> studentsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] currentStudentData = scanner.nextLine().split(" ");
            String firstName = currentStudentData[0];
            String secondName = currentStudentData[1];
            double grade = Double.parseDouble(currentStudentData[2]);

            Student currentStudent = new Student(firstName, secondName, grade);
            studentsList.add(currentStudent);

        }
        //сортиране на List по поле на обекта, пренаписваме метода compare
        Collections.sort(studentsList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o2.getGrade() * 100 - o1.getGrade() * 100);
            }
        });

        for (Student student : studentsList) {
            System.out.println(student.toString());
        }

    }
}
