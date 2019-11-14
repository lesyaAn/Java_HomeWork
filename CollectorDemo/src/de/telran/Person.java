package de.telran;

public class Person {
    String name;
    int salary;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Person(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
