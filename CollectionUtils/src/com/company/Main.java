package com.company;

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List s = new ArrayList<Double>();
        List d = new ArrayList<Character>();    //?????????
        s.add(5);
        CollectionUtils.addAll(s, d);

        System.out.print(d.get(0));
    }
}
