package ru.university.lab3.words;

import java.util.HashMap;
import java.util.Map;

/**
 * Задание 4. Частота слов (HashMap), регистр не учитывается.
 */
public class Task04WordFrequency {

    private static final String TEXT =
            "The quick brown fox jumps over the lazy dog. "
                    + "The dog barks, and the fox runs away. "
                    + "A quick fox is a happy fox!";

    public void run() {
        System.out.println("Текст: " + TEXT);
        String[] words = extractWords(TEXT);
        Map<String, Integer> frequency = countFrequency(words);
        printDistinctWords(frequency);
        printFrequency(frequency);
    }

    // Приводим к нижнему регистру (The == the) и режем по всему, что не буква.
    private String[] extractWords(String text) {
        return text.toLowerCase().split("[^a-z]+");
    }

    // merge: если слова нет - кладёт 1, если есть - прибавляет 1.
    private Map<String, Integer> countFrequency(String[] words) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                frequency.merge(word, 1, Integer::sum);
            }
        }
        return frequency;
    }

    // Различные слова - это ключи map.
    private void printDistinctWords(Map<String, Integer> frequency) {
        System.out.println("Различных слов: " + frequency.size());
        System.out.println(frequency.keySet());
    }

    // Порядок вывода у HashMap не гарантирован.
    private void printFrequency(Map<String, Integer> frequency) {
        System.out.println("Частота (слово -> раз):");
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
