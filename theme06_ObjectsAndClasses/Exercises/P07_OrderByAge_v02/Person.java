package theme06_ObjectsAndClasses.Exercises.P07_OrderByAge_v02;

public class Person {
    private String name;
    private String id;
    private int age;

    public Person(String name, String personID, int age) {
        this.name = name;
        this.id = personID;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return String.format("%s with ID: %s is %s years old.", this.name, this.id, this.age);
    }
}
