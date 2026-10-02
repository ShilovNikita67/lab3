package ru.university.lab3.sets;

import java.util.Objects;

/**
 * Человек: имя, фамилия, возраст.
 * Естественный порядок (Comparable): фамилия, затем имя, затем возраст.
 * equals/hashCode согласованы с compareTo (равны при совпадении всех трёх полей),
 * иначе HashSet не смог бы отличить дубликаты.
 */
public class Human implements Comparable<Human> {

    private final String firstName;
    private final String lastName;
    private final int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        int result = lastName.compareTo(other.lastName);
        if (result != 0) {
            return result;
        }
        result = firstName.compareTo(other.firstName);
        if (result != 0) {
            return result;
        }
        return Integer.compare(age, other.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Human other)) {
            return false;
        }
        return age == other.age
                && firstName.equals(other.firstName)
                && lastName.equals(other.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " (" + age + ")";
    }
}
