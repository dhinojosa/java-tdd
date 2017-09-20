package com.xyzcorp.junit5.samples;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class DieTest {

    @Test
    void testDefaultOf1() {

    }

    @Test
    void testRollOf4() {
        Random randomStub = new Random() {
            int[] nextValue = {3,5,1,6,2};
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };

        Die die = new Die(randomStub);
        int pip = die.roll();
    }
}
