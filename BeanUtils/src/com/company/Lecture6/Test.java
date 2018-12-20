package com.company.Lecture6;

public class Test {
    public static void main(String[] args) {
        // int String String
        // public public public
        TestClass1 fromClass = new TestClass1(2, "2", true);
        // Number String boolean
        // public private public
        TestClass2 toClass = new TestClass2(1, "1", false);
        BeanUtils bean = new BeanUtils();

        bean.fromGetterToSetter(fromClass, toClass);
        System.out.print(toClass.getNumber() + " " + toClass.getString() + " " + toClass.getBool() + "\n");
    }
}
