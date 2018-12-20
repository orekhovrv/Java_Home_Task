package com.company;

import java.util.List;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Scanner;

public class acm_2036 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String word;
        boolean isStrange;
        List<Character> list = Arrays.asList('e','y', 'u', 'i', 'o', 'a');
        HashSet<Character> vowelHashSet = new HashSet<>(list);
        // по словам
        for (int i = 0; i < count; i++) {
            isStrange = false;
            word = scanner.next();
            //по буквам в слове
            for (int j = 0; j < word.length() - 2; j++) {
                if (vowelHashSet.contains(word.charAt(j)) && vowelHashSet.contains(word.charAt(j+1)) && vowelHashSet.contains(word.charAt(j+2))) {
                    isStrange = true;
                    break;
                }
            }
            if (!isStrange) {
                System.out.println(word);
            }
        }
    }
}


