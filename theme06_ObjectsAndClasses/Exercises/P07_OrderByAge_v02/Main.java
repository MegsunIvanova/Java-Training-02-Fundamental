package theme06_ObjectsAndClasses.Exercises.P07_OrderByAge_v02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> peopleList = new ArrayList<>();
        String personalData = scanner.nextLine();

        while (!personalData.equals("End")) {
            String name = personalData.split(" ")[0];
            String id = personalData.split(" ")[1];
            int age = Integer.parseInt(personalData.split(" ")[2]);

            Person person = new Person(name, id, age);
            peopleList.add(person);

            personalData = scanner.nextLine();
        }

        peopleList.sort(Comparator.comparing(Person::getAge));

        for (Person person : peopleList) {
            System.out.println(person.toString());
        }

    }
}

