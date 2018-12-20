package com.company;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountMapImpl<V> implements CountMap<V> {

    public class Node<V> {
        final V val;
        int count;

        public Node(V val, int count) {
            this.val = val;
            this.count = count;
        }
        private Node(V val) {
            this.val = val;
            count = 1;
        }

        public V getVal() {
            return val;
        }

        public int getCount() {
            return count;
        }

        public int add() {
            return ++this.count;
        }

        public int remove() {
            return --this.count;
        }
    }

    // Fields
    private Set<Node> entrySet = new HashSet<>();
    private int size;

    public CountMapImpl() {
        this.size = 0;
    }

    // Methods
    @Override
    public void add(V val) {
        boolean isFound = false;
        for (Node node: entrySet) {
            if (node.val == val) {
                node.count++;
                isFound = true;
            }
        }
        if (!isFound) {
            entrySet.add(new Node<>(val));
        }
    }

    @Override
    public int getCount(V val) {
        for (Node node: entrySet) {
            if (node.val == val) {
                return node.count;
            }
        }
        return 0;
    }

    @Override
    public int remove(V val) {
        for (Node node: entrySet) {
            if (node.val == val) {
                if (node.count > 1) {
                    return node.count--;
                } else {
                    entrySet.remove(node);
                    return node.count;
                }

            }
        }
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addAll(CountMap source) {
        // Тут закончил
    }

    @Override
    public Map toMap() {
        return null;
    }

    @Override
    public void toMap(Map destination) {

    }
}
