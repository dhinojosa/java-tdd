package com.xyzcorp.instructor;

import java.util.Random;

//Subject under test
public class Die {

    private final Random random;
    private final int pip;

    public Die(Random random) {
        this(random, 1);
    }

    private Die(Random random, int pip) {
        this.pip = pip;
        this.random = random;
    }

    public int getPips() {
        return pip;
    }

    public Die roll() {
        return new Die(random, random.nextInt(6) + 1);
    }
}
