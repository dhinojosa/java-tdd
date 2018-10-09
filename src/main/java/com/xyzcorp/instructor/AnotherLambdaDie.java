package com.xyzcorp.instructor;

import java.util.function.Supplier;

public class AnotherLambdaDie implements Die {

    public AnotherLambdaDie(Supplier<Integer> supplier) {
    }

    @Override
    public int getPip() {
        return 0;
    }

    @Override
    public Die roll() {
        return null;
    }
}
