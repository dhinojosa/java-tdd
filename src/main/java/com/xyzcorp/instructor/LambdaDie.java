package com.xyzcorp.instructor;

import java.util.function.Function;

public class LambdaDie implements Die {
    private Function<Integer, Integer> fun;

    public LambdaDie(Function<Integer, Integer> integerIntegerFunction) {
        fun = integerIntegerFunction;
    }

    @Override
    public int getPips() {
        return 0;
    }

    @Override
    public Die roll() {
        return null;
    }
}
