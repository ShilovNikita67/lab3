package ru.university.lab3.sets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Задание 3. Множества и сравнение объектов.
 */
public class Task03Sets {

    public void run() {
        List<Human> humans = createHumans();                           // 1
        fillHashSet(humans);                                           // 2
        fillLinkedHashSet(humans);                                     // 3
        fillTreeSet(humans);                                           // 4
        fillTreeSetByLastName(humans);                                 // 5
        fillTreeSetByAge(humans);                                      // 6
        explainDifferences();                                          // 7
    }

    // 1. Список людей. Ivanov Ivan (20) добавлен дважды - это разные объекты с одинаковыми данными.
    // Фамилия Ivanov и Petrov встречаются несколько раз, возраст 25 и 30 - тоже.
    private List<Human> createHumans() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Ivan", "Ivanov", 20));
        humans.add(new Human("Petr", "Petrov", 25));
        humans.add(new Human("Sidor", "Sidorov", 30));
        humans.add(new Human("Aleksey", "Ivanov", 22));
        humans.add(new Human("Oleg", "Smirnov", 25));
        humans.add(new Human("Ivan", "Ivanov", 20));
        humans.add(new Human("Anna", "Kuznetsova", 30));
        humans.add(new Human("Maksim", "Petrov", 19));
        printCollection("1. Список (" + humans.size() + " чел.)", humans);
        return humans;
    }

    // 2. HashSet: дубликаты убираются через equals/hashCode, порядок не гарантирован.
    private void fillHashSet(List<Human> humans) {
        Set<Human> set = new HashSet<>(humans);
        printCollection("2. HashSet", set);
    }

    // 3. LinkedHashSet: то же, но порядок вставки сохраняется.
    private void fillLinkedHashSet(List<Human> humans) {
        Set<Human> set = new LinkedHashSet<>(humans);
        printCollection("3. LinkedHashSet", set);
    }

    // 4. TreeSet без компаратора: порядок задаёт Human.compareTo (естественный порядок).
    private void fillTreeSet(List<Human> humans) {
        Set<Human> set = new TreeSet<>(humans);
        printCollection("4. TreeSet (Comparable)", set);
    }

    // 5. TreeSet с компаратором по фамилии.
    private void fillTreeSetByLastName(List<Human> humans) {
        Set<Human> set = new TreeSet<>(new HumanComparatorByLastName());
        set.addAll(humans);
        printCollection("5. TreeSet (по фамилии)", set);
    }

    // 6. TreeSet с анонимным компаратором по возрасту.
    private void fillTreeSetByAge(List<Human> humans) {
        Set<Human> set = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human first, Human second) {
                return Integer.compare(first.getAge(), second.getAge());
            }
        });
        set.addAll(humans);
        printCollection("6. TreeSet (по возрасту)", set);
    }

    // 7. Объяснение различий.
    //
    // HashSet: уникальность определяют equals() и hashCode(). Второй Ivanov Ivan (20)
    //   равен первому, поэтому в множестве остаётся один. Порядок элементов зависит от
    //   хеш-кодов и не гарантируется.
    // LinkedHashSet: уникальность та же, но элементы хранятся в порядке добавления.
    // TreeSet (Comparable): уникальность и порядок определяет compareTo(); элементы
    //   отсортированы по фамилии, имени, возрасту. Дубликат отсекается, потому что
    //   compareTo вернул 0.
    // TreeSet (по фамилии): TreeSet считает элементы равными, когда компаратор вернул 0,
    //   и equals() не использует. Для компаратора по фамилии все Ivanov "одинаковые",
    //   все Petrov тоже, поэтому остаётся только первый добавленный из каждой фамилии.
    // TreeSet (по возрасту): аналогично, но людей с одинаковым возрастом считаем
    //   одинаковыми: остаётся первый добавленный человек каждого возраста.
    private void explainDifferences() {
        System.out.println("7. Различия:");
        System.out.println("   HashSet - дубликаты по equals/hashCode, порядок не гарантирован.");
        System.out.println("   LinkedHashSet - то же, но порядок добавления сохраняется.");
        System.out.println("   TreeSet (Comparable) - порядок и дубликаты определяет compareTo.");
        System.out.println("   TreeSet с компаратором - \"равны\" те, у кого compare == 0,");
        System.out.println("   поэтому люди с той же фамилией (или возрастом) теряются.");
    }

    private void printCollection(String title, Collection<Human> collection) {
        System.out.println(title + ":");
        for (Human human : collection) {
            System.out.println("   " + human);
        }
    }
}
