package com.xyzcorp;

import java.util.Random;

public class JavaUtilRandomDie implements Die {
    private final int pips;
    private final Random random;

    public JavaUtilRandomDie(Random random) {
        this(random, 1);
    }

    private JavaUtilRandomDie(Random random, int pips) {
        this.random = random;
        this.pips = pips;
    }

    public int getPips() {
        return pips;
    }

    public Die roll() {
        return new JavaUtilRandomDie(random, random.nextInt(6) + 1);
    }
}
