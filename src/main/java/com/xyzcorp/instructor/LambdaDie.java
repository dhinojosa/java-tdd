package com.xyzcorp.instructor;

import java.util.function.Function;

public class LambdaDie implements Die{
    private  Function<Integer, Integer> function;
    private  int pip;

    public LambdaDie(Function<Integer, Integer> function) {
        this.function = function;
    }

    public LambdaDie(int pip) {
        this.pip = pip;
    }

    @Override
    public int getPip() {
        return pip;
    }

    @Override
    public Die roll() {
        return new LambdaDie(function.apply(6));
    }
}
