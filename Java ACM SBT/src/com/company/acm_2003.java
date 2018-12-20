package com.company;

import java.util.Scanner;

public class acm_2003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                sum += scanner.nextInt();
            } else {
                sum -= scanner.nextInt();
            }
        }

        System.out.println(sum);
    }
}