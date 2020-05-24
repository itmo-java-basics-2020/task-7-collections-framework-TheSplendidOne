package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private LinkedHashMap<Integer, Integer> counters;

    public FirstUnique(int[] numbers) {
        counters = new LinkedHashMap<>();
        for (var number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        for (Map.Entry<Integer, Integer> item : counters.entrySet())
            if (item.getValue() == 1)
                return item.getKey();
        return -1;
    }

    public void add(int value) {
        if (counters.containsKey(value))
            counters.compute(value, (key, val) -> val + 1);
        else
            counters.put(value, 1);
    }
}
