package com.company;

import java.util.*;

public class CountMapImpl<K> implements CountMap<K> {

    public Map<K, Integer> entryMap;

    public CountMapImpl() { entryMap = new HashMap<>(); }

    // Methods
    @Override
    public void add(K key) {
        boolean isFound = false;
        for (Map.Entry<K, Integer> entry : entryMap.entrySet()) {
            if (entry.getKey() == key) {
                entryMap.put(key, entry.getValue() + 1);
                isFound = true;
            }
        }
        if (!isFound) {
            entryMap.put(key, 1);
        }
    }

    @Override
    public int getCount(K key) {
        return entryMap.get(key);
    }

    @Override
    public int remove(K key) {
        for (Map.Entry<K, Integer> entry : entryMap.entrySet()) {
            if (entry.getKey() == key) {
                int val = entry.getValue();
                if ( entry.getValue() > 1) {
                    entryMap.put(key, entry.getValue() - 1);
                } else {
                    entryMap.remove(key);
                }
                return val;
            }
        }
        return 0;
    }

    @Override
    public int size() {
        return entryMap.size();
    }

    @Override
    public void addAll(CountMap<K> source) {
        Map<K, Integer> sourceMap = source.toMap();
        for (Map.Entry<K, Integer> entrySource : sourceMap.entrySet() ) {
            K sourceKey = entrySource.getKey();
            if (entryMap.get(sourceKey) != null) {
                entryMap.put(sourceKey, entryMap.get(sourceKey) + entrySource.getValue());
            } else {
                entryMap.put(sourceKey, entrySource.getValue());
            }
        }
    }

    @Override
    public Map<K, Integer> toMap() {
        return entryMap;
    }

    @Override
    public void toMap(Map<K, Integer> destination) {
        destination.putAll(entryMap);
    }
}
