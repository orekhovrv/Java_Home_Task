package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * PECS
 * producer - extends
 * consumer - super
 */

public class CollectionUtils<T> {

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) { destination.addAll(source); }

    public static<T> List<T> newArrayList() { return new ArrayList<>(); }

    // тут мб просто T
    public static<T> int indexOf(List<? extends T> source, T o) { return source.indexOf(o); }

    public static<T> List<T> limit(List<T> source, int size) {
//        for (int i = size; i < source.size(); i++) {
//            source.remove(i);
//        }
        return source.subList(0, size);
    }

    public static<T> void add(List<? super T> source, T o) { source.add(o); }

    public static<T> void removeAll(List<? super T> c1, List<? extends T> c2) { c1.removeAll(c2); }

    public static<T> boolean containsAll(List<? super T> c1, List<? extends T> c2) { return c1.containsAll(c2); }

    public static<T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T object : c2) {
            if (c1.contains(object)) {
                return true;
            }
        }
        return false;
    }

    // Возможно Comparable<T>
    public static<T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> resultList = new ArrayList<>();
        for (T object : list) {
            if (object.compareTo(min) == 1 && object.compareTo(max) == -1) {
                resultList.add(object);
            }
        }
        return resultList;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> resultList = new ArrayList<>();
        for (T object: list) {
            if(comparator.compare(object, min) >= 0 && comparator.compare(object, max) <= 0) {
                resultList.add(object);
            }
        }
        return resultList;
    }
}