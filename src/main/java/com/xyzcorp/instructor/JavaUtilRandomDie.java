package com.xyzcorp.instructor;

import java.util.Random;

//Subject under test
public class JavaUtilRandomDie implements Die {

    private final Random random;
    private final int pip;

    public JavaUtilRandomDie(Random random) {
        this(random, 1);
    }

    private JavaUtilRandomDie(Random random, int pip) {
        this.pip = pip;
        this.random = random;
    }

    public static Die create() {
        return new JavaUtilRandomDie(new Random());
    }

    @Override
    public int getPips() {
        return pip;
    }

    @Override
    public Die roll() {
        return new JavaUtilRandomDie(random, random.nextInt(6) + 1);
    }
}
