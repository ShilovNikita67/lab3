package ru.university.lab3.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * Задание 1. Методы класса Collections.
 */
public class Task01CollectionsMethods {

    private static final int N = 30;
    private static final int MAX_VALUE = 100;

    public void run() {
        Integer[] array = createRandomArray(N);                // 1
        List<Integer> list = createList(array);                // 2
        sortAscending(list);                                   // 3
        sortDescending(list);                                  // 4
        shuffle(list);                                         // 5
        rotate(list, 1);                               // 6

        // Шаги 7 и 8 меняют список, поэтому выполняем их на копиях,
        // чтобы оба результата считались от одного и того же списка.
        List<Integer> unique = new ArrayList<>(list);
        keepUnique(unique);                                    // 7
        List<Integer> duplicates = new ArrayList<>(list);
        keepDuplicates(duplicates);                            // 8

        toArray(list);                                         // 9
        countOccurrences(list);                                // 10
    }

    // 1. Массив из N случайных чисел от 0 до 100.


    private Integer[] createRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(MAX_VALUE + 1);
        }
        System.out.println("1. Массив:           " + Arrays.toString(array));
        return array;
    }

    // 2. Список на основе массива. Копия в ArrayList, чтобы список можно было менять.
    private List<Integer> createList(Integer[] array) {
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("2. Список:           " + list);
        return list;
    }

    // 3. По возрастанию.
    private void sortAscending(List<Integer> list) {
        Collections.sort(list);
        System.out.println("3. По возрастанию:   " + list);
    }

    // 4. В обратном порядке.
    private void sortDescending(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("4. По убыванию:      " + list);
    }

    // 5. Перемешивание.
    private void shuffle(List<Integer> list) {
        Collections.shuffle(list);
        System.out.println("5. Перемешан:        " + list);
    }

    // 6. Циклический сдвиг: последний элемент становится первым.
    private void rotate(List<Integer> list, int distance) {
        Collections.rotate(list, distance);
        System.out.println("6. Сдвиг на " + distance + ":        " + list);
    }

    // 7. Только уникальные: каждое значение остаётся один раз, порядок сохраняется.

    private void keepUnique(List<Integer> list) {
        List<Integer> withoutRepeats = new ArrayList<>(new LinkedHashSet<>(list));
        list.clear();
        list.addAll(withoutRepeats);
        System.out.println("7. Без повторов:     " + list);
    }

    // 8. Только дублирующиеся: значения, которые встречаются больше одного раза.
    // Collections.frequency считает вхождения, каждое значение берём один раз.
    private void keepDuplicates(List<Integer> list) {
        List<Integer> repeated = new ArrayList<>();
        for (Integer value : list) {
            if (Collections.frequency(list, value) > 1 && !repeated.contains(value)) {
                repeated.add(value);
            }
        }
        list.clear();
        list.addAll(repeated);
        System.out.println("8. Только дубли:     " + list);
    }

    // 9. Список -> массив.
    private Integer[] toArray(List<Integer> list) {
        Integer[] array = list.toArray(new Integer[0]);
        System.out.println("9. Массив из списка: " + Arrays.toString(array));
        return array;
    }

    // 10. Сколько раз встречается каждое число. TreeSet даёт отсортированные различные значения.
    private void countOccurrences(List<Integer> list) {
        System.out.println("10. Количество вхождений (число -> раз):");
        for (Integer value : new TreeSet<>(list)) {
            System.out.println("    " + value + " -> " + Collections.frequency(list, value));
        }
    }
}
