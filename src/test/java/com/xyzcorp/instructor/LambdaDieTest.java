package com.xyzcorp.instructor;

import org.junit.Test;

import java.util.Random;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaDieTest {


    @Test
    public void testDieRoll2() {
        LambdaDie lambdaDie = new LambdaDie(bound -> 2);
        assertThat(lambdaDie.roll().getPips()).isEqualTo(2);
    }

    @Test
    public void testIntegrationTest() {
        Random random = new Random();
        LambdaDie lambdaDie = new LambdaDie(bound ->
                random.nextInt(bound) + 1);

    }
}
