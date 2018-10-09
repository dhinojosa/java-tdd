package com.xyzcorp.instructor;

import java.util.Random;

public class JavaUtilRandomDie implements Die {
    private final Random random;
    private final int pip;

    private JavaUtilRandomDie(Random random, int pip) {
        this.random = random;
        this.pip = pip;
    }

    public JavaUtilRandomDie(Random random) {
        this(random, 1);
    }

    @Override
    public int getPip() {
        return pip;
    }

    @Override
    public Die roll() {
        return new JavaUtilRandomDie(random, random.nextInt(6) + 1);
    }
}
