package com.company;

public interface Person {
    // Fields
    boolean sex = false; // 1 == male, = == female
    String name = null;


    // Methods
    boolean isMarred();

    boolean marry();

    boolean divorce();

    // Getters


    default boolean getSex() {
        return sex;
    }

    default String getName() {
        return name;
    }
}

