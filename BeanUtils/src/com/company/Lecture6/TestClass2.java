package com.company.Lecture6;

public class TestClass2 {
    public Number number;
    public String string;
    public boolean bool;

    public TestClass2(Number number, String string, boolean bool) {
        this.number = number;
        this.string = string;
        this.bool = bool;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    private void setString(String string) {
        this.string = string;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }



    public Number getNumber() {
        return number;
    }

    public String getString() {
        return string;
    }

    public boolean getBool() {
        return bool;
    }
}
