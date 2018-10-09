package com.xyzcorp.instructor;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaDieTest {
    @Test
    public void testRoll4() {
        LambdaDie lambdaDie = new LambdaDie(integer -> 4);
        assertThat(lambdaDie.roll().getPip()).isEqualTo(4);
    }

    @Test
    @Category(value = IntegrationTest.class)
    public void testRollWithSomethingReal() {
        Random random = new Random();

        AnotherLambdaDie anotherLambdaDie = new AnotherLambdaDie(() -> random.nextInt(6));
        LambdaDie lambdaDie = new LambdaDie(bound -> random.nextInt(bound));
        assertThat(lambdaDie.roll().getPip()).isEqualTo(4);

    }
}
