package com.xyzcorp;

import java.util.Random;

public class DieJavaRandom implements Die {
    private final int pips;
    private final Random random;

    public DieJavaRandom(Random random) {
        this(random, 1);
    }

    //private constructor
    private DieJavaRandom(Random random, int pips) {
        this.random = random;
        this.pips = pips;
    }

    @Override
    public int getPips() {
        return pips;
    }

    @Override
    public Die roll() {
        return new DieJavaRandom(random, random.nextInt(6) + 1);
    }

    public static Die create() {
        return new DieJavaRandom(new Random());
    }
}
