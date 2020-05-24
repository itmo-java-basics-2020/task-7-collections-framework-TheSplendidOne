package ru.ifmo.collections;

import java.util.*;

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