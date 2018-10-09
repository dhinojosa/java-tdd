package com.xyzcorp.instructor;

import java.util.Random;

public class Die {
    private final Random random;
    private final int pip;

    private Die(Random random, int pip) {
        this.random = random;
        this.pip = pip;
    }

    public Die(Random random) {
        this(random, 1);
    }

    public int getPip() {
        return pip;
    }

    public Die roll() {
        return new Die(random, random.nextInt(6) + 1);
    }
}
