package ru.university.lab3.primes;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Генератор первых N простых чисел.
 * Обход - через Iterator: прямой (iterator) и обратный (reverseIterator).
 */
public class PrimesGenerator implements Iterable<Integer> {

    private final int[] primes;

    public PrimesGenerator(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество чисел не может быть отрицательным: " + count);
        }
        this.primes = generate(count);
    }

    private static int[] generate(int count) {
        int[] result = new int[count];
        int found = 0;
        int candidate = 2;
        while (found < count) {
            if (isPrime(candidate)) {
                result[found++] = candidate;
            }
            candidate++;
        }
        return result;
    }

    // Делители достаточно проверять до корня из n.
    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int divisor = 2; (long) divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    /** Прямой порядок: от меньшего к большему. */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < primes.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return primes[index++];
            }
        };
    }

    /** Обратный порядок: от большего к меньшему. */
    public Iterator<Integer> reverseIterator() {
        return new Iterator<>() {
            private int index = primes.length - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return primes[index--];
            }
        };
    }
}
