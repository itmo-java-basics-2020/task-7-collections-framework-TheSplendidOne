package ru.ifmo.collections;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 * <p>
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 * <p>
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private static final Object current = new Object();
    private final Map<T, Object> map;

    private SortedSet(TreeMap<T, Object> treeMap) {
        map = treeMap;
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<>(new TreeMap<>());
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(new TreeMap<>(comparator));
    }

    public List<T> getSorted() {
        return new ArrayList<>(map.keySet());
    }

    public List<T> getReversed() {
        List<T> list = new ArrayList<>(map.keySet());
        Collections.reverse(list);
        return list;
    }

    @Override
    public boolean add(T t) {
        return map.put(t, current) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean isAllAdded = false;
        for (T it : c) {
            isAllAdded |= add(it);
        }
        return isAllAdded;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o, current);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isAllRemoved = false;
        for (Object it : c) {
            isAllRemoved |= remove(it);
        }
        return isAllRemoved;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}