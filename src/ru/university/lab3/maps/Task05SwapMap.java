package ru.university.lab3.maps;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Задание 5. Обмен ключей и значений.
 */
public class Task05SwapMap {

    public void run() {
        demoUniqueValues();
        demoDuplicateValues();
    }

    // Значения уникальны: ничего не теряется.
    private void demoUniqueValues() {
        Map<String, Integer> source = new LinkedHashMap<>();
        source.put("one", 1);
        source.put("two", 2);
        source.put("three", 3);
        printResult("Уникальные значения", source, MapUtils.swapKeysAndValues(source));
    }

    // Значения повторяются: ключи нового Map уникальны, поэтому одна пара теряется.
    // LinkedHashMap гарантирует порядок обхода, значит "последней" будет banana.
    private void demoDuplicateValues() {
        Map<String, String> source = new LinkedHashMap<>();
        source.put("apple", "fruit");
        source.put("banana", "fruit");
        source.put("carrot", "vegetable");
        printResult("Повторяющиеся значения", source, MapUtils.swapKeysAndValues(source));
    }

    private void printResult(String title, Map<?, ?> source, Map<?, ?> swapped) {
        System.out.println(title + ":");
        System.out.println("   было:  " + source);
        System.out.println("   стало: " + swapped);
    }
}
