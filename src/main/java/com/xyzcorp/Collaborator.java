package com.xyzcorp;

public class Collaborator {

    public int method1(int a, int b) {
        return a + b;
    }

    public String method2 (int a, boolean s) {
        if (s) {
            return "Belgium" + a;
        } else {
            return "France" + (a + 2);
        }
    }

    public String method3(String s) {
        return s + "!";
    }
}
