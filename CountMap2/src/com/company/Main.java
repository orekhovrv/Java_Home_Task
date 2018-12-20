package com.company;

public class Main {

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();
        CountMap<Integer> map2 = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);


        map2.add(0);
        map2.add(4);
        map2.add(5);
        map2.add(6);
        map2.add(6);

        map.addAll(map2);

        int count = map.getCount(5); // 2
        System.out.print(count);
        count = map.getCount(6); // 1
        System.out.print(count);
        count = map.getCount(10); // 3
        System.out.print(count);
        count = map.getCount(0); // 3
        System.out.print(count);


    }
}
