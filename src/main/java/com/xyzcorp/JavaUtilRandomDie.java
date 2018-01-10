package com.xyzcorp;

import java.util.Random;

public class JavaUtilRandomDie implements Die {

    private Random random;
    private int pips;

    public JavaUtilRandomDie(Random random) {
        this.random = random;
    }

    public JavaUtilRandomDie(Random random, int pips) {
        this.random = random;
        this.pips = pips;
    }

    @Override
    public int getPips() {
        return pips;
    }

    @Override
    public Die roll() {
        return new JavaUtilRandomDie(random, random.nextInt(6));
    }
}
