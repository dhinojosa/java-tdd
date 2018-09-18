package com.xyzcorp;

import java.util.function.BiFunction;

public class MyAfter {

    private final BiFunction<Integer, Integer, Integer> f;

    public MyAfter(BiFunction<Integer, Integer, Integer> f) {
        this.f = f;
    }

    public int importantMethod() {
        return f.apply(1,4);
    }

    public static void main(String[] args) {
        Collaborator collaborator = new Collaborator();
        MyAfter myAfter = new MyAfter(collaborator::method1);
        System.out.println(myAfter.importantMethod());
    }
}
