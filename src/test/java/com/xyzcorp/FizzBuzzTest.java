package com.xyzcorp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {
    @Test
    public void testOne() {
        assertThat(FizzBuzz.convert(1)).isEqualTo("1");
    }

    @Test
    public void testThree() {
        assertThat(FizzBuzz.convert(3)).isEqualTo("Fizz");
    }
}
