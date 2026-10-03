package ru.university.lab3.maps;

import java.util.HashMap;
import java.util.Map;

public final class MapUtils {

    private MapUtils() {
    }

    /**
     * Возвращает новую Map, где ключи и значения поменяны местами.
     * Исходная Map не меняется.
     * Если в исходной Map есть одинаковые значения, они станут одним ключом,
     * и в результате останется пара, обработанная последней.
     */
    public static <K, V> Map<V, K> swapKeysAndValues(Map<K, V> source) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry<K, V> entry : source.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }
}
