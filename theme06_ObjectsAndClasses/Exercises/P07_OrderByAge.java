package theme06_ObjectsAndClasses.Exercises;

import java.util.*;

public class P07_OrderByAge {
    static class Person {
        private String name;
        private String personID;
        private int age;

        public Person(String name, String personID, int age) {
            this.name = name;
            this.personID = personID;
            this.age = age;
        }

        public String toString() {
            return this.name + " with ID: " + this.personID + " is " + this.age + " years old.";
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        List<Person> peopleList = new ArrayList<>();

        while (!inputLine.equals("End")) {
            String[] currentPersonData = inputLine.split(" ");

            String name = currentPersonData[0];
            String personID = currentPersonData[1];
            int age = Integer.parseInt(currentPersonData[2]);

            Person currentPerson = new Person(name, personID, age);
            peopleList.add(currentPerson);

            inputLine = scanner.nextLine();
        }

        Collections.sort(peopleList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (Person currentPerson : peopleList) {
            System.out.println(currentPerson.toString());
        }

    }

}
