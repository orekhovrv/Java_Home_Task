package com.company.Lecture6;

public class TestClass1 {
    public int number;
    public String string;
    public boolean bool;

    public TestClass1(int number, String string, boolean bool) {
        this.number = number;
        this.string = string;
        this.bool = bool;
    }

    public int getNumber() {
        return number;
    }

    public String getString() {
        return string;
    }

    public boolean getBool() {
        return bool;
    }



    public void setnumber(int number) {
        this.number = number;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

}
