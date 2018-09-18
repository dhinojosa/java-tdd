package com.xyzcorp;

public class MyBefore {

    private final Collaborator c;

    public MyBefore(Collaborator c) {
        this.c = c;
    }

    public int importantMethod() {
        return c.method1(4,3);
    }
}
