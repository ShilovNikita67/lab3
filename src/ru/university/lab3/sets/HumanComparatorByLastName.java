package ru.university.lab3.sets;

import java.util.Comparator;

/** Сравнивает людей только по фамилии. */
public class HumanComparatorByLastName implements Comparator<Human> {

    @Override
    public int compare(Human first, Human second) {
        return first.getLastName().compareTo(second.getLastName());
    }
}
