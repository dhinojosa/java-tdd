package com.xyzcorp;

import java.util.Random;

public class JavaUtilRandomDie implements Die {

    private final Random random;
    private final int pips;

    public JavaUtilRandomDie(Random random) {
        this(random, 1);
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
        return new JavaUtilRandomDie(random, 1 + random.nextInt(6));
    }
}
