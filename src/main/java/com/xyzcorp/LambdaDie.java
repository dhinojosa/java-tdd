package com.xyzcorp;

import java.util.function.Function;

public class LambdaDie implements Die {
    public LambdaDie(Function<Integer, Integer> function) {

    }

    @Override
    public int getPips() {
        return 0;
    }

    public Die roll() {
        return null;
    }
}
