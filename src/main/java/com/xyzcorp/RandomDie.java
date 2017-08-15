package com.xyzcorp;


import java.util.Random;

public class RandomDie implements Die {
    private final Random random;
    private final int pips;

    public RandomDie(Random random) {
        this(random, 1);
    }

    public RandomDie(Random random, int pips) {
        this.random = random;
        this.pips = pips;
    }

    @Override
    public int getPips() {
        return pips;
    }

    @Override
    public Die roll() {
        return new RandomDie(random, 1 + random.nextInt(6));
    }
}
