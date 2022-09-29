package theme06_ObjectsAndClasses.Exercises;

import java.util.*;

public class P01_CompanyRoster_me {
    static class Employee {
        private String name;
        private double salary;
        private String position;
        private String email;
        private int age;

        //The name, salary, position, and department are mandatory
        // while the rest are optional.

        public Employee(String name, double salary, String position) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.email = "n/a";
            this.age = -1;

        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public String toString() {
            return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        }
    }

    static class Department {
        private String departmentName;
        private List<Employee> employeesList;
        private double averageSalary;

        public Department(String departmentName) {
            this.departmentName = departmentName;
            this.employeesList = new ArrayList<>();
            this.averageSalary = 0;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void addEmployeeToList(Employee employee) {
            this.employeesList.add(employee);
            setAverageSalaryForDepartment();
            Collections.sort(employeesList, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return (int) (o2.getSalary() * 100 - o1.getSalary() * 100);
                }
            });
        }

        public List<Employee> getDepartmentSEmployeesList() {
            return this.employeesList;
        }

        private void setAverageSalaryForDepartment() {
            double sumSalaries = 0;
            for (Employee currentEmployee : this.employeesList) {
                sumSalaries += currentEmployee.getSalary();
            }
            this.averageSalary = sumSalaries / this.employeesList.size();
        }

        public double getAverageSalaryForDepartment() {
            return this.averageSalary;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departmentsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] employeeData = scanner.nextLine().split(" ");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            Department department = getDepartmentByName(departmentsList, employeeData[3]);
            Employee currentEmployee = new Employee(name, salary, position);

            if (employeeData.length == 5) {
                if (employeeData[4].contains("@")) {
                    String email = employeeData[4];
                    currentEmployee.setEmail(email);
                } else {
                    int age = Integer.parseInt(employeeData[4]);
                    currentEmployee.setAge(age);
                }
            } else if (employeeData.length == 6) {
                String email = employeeData[4];
                currentEmployee.setEmail(email);
                int age = Integer.parseInt(employeeData[5]);
                currentEmployee.setAge(age);
            }

            department.addEmployeeToList(currentEmployee);

        }

        Department departmentWithMaxAverageSalary = departmentsList.stream()
                .max(Comparator.comparingDouble(Department::getAverageSalaryForDepartment))
                .get();
        System.out.printf("Highest Average Salary: %s\n"
                , departmentWithMaxAverageSalary.getDepartmentName());

        for (Employee currentEmployee : departmentWithMaxAverageSalary
                .getDepartmentSEmployeesList()) {
            System.out.println(currentEmployee.toString());
        }


//        //print
//        for (Department currentDepartment : departmentsList) {
//            System.out.println(currentDepartment.departmentName);
//            for (Employee currentEmployee : currentDepartment.getDepartmentSEmployeesList()) {
//                System.out.println(currentEmployee.toString());
//            }
//        }
    }

    private static Department getDepartmentByName
            (List<Department> departmentsList, String departmentName) {
        for (Department currentDepartment : departmentsList) {
            if (currentDepartment.getDepartmentName().equals(departmentName)) {
                return currentDepartment;
            }
        }
        Department newDepartment = new Department(departmentName);
        departmentsList.add(newDepartment);
        return newDepartment;
    }

}
