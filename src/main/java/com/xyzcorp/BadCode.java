package com.xyzcorp;

public class BadCode {

    private float foo() {
        //Goes off into the internet
        //10000 lines of code
        return 123.00f;
    }

    public float bar() {
        return foo() + 30;
    }
}
