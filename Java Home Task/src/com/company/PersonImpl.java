package com.company;

public class PersonImpl implements Person {
    private final boolean sex; // 1 == male, = == female
    private final String name;
    private Person spouse;

    public PersonImpl(boolean sex, String name) {
        this.sex = sex;
        this.name = name;
    }


    public boolean marry(Person person) {
        if (this.sex != person.getSex()) {
            this.divorce();
            this.spouse = person;
            person.marry(this);
        }
    }


    public boolean divorce() {
        if (this.isMarred()) {
            this.spouse = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean isMarred() {
        return this.spouse != null;
    }

    public Person getSpouse() {
        return spouse;
    }
}
