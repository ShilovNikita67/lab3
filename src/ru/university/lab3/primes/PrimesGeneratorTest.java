package ru.university.lab3.primes;

import java.util.Iterator;

/**
 * Задание 2. Проверочный класс: выводит первые N простых чисел
 * в прямом и обратном порядке.
 */
public class PrimesGeneratorTest {

    private static final int N = 15;

    public void run() {
        PrimesGenerator generator = new PrimesGenerator(N);
        printForward(generator);
        printBackward(generator);
    }

    private void printForward(PrimesGenerator generator) {
        printAll("Первые " + N + " простых чисел (прямой порядок):", generator.iterator());
    }

    private void printBackward(PrimesGenerator generator) {
        printAll("Те же числа (обратный порядок):", generator.reverseIterator());
    }

    private void printAll(String title, Iterator<Integer> iterator) {
        StringBuilder line = new StringBuilder();
        while (iterator.hasNext()) {
            if (line.length() > 0) {
                line.append(", ");
            }
            line.append(iterator.next());
        }
        System.out.println(title);
        System.out.println(line);
    }
}
