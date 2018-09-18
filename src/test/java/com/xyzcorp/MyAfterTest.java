package com.xyzcorp;

import org.junit.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class MyAfterTest {

    @Test
    public void testMyAfterTest() {
        MyAfter myAfter = new MyAfter((a, b) -> a + b);
        int result = myAfter.importantMethod();
        assertThat(result).isEqualTo(5);
    }
}