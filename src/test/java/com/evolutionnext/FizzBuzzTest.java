package com.evolutionnext;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {
    @Test
    public void testOne() throws Exception {
        assertThat(FizzBuzz.translate(1)).isEqualTo("1");
    }

    @Test
    public void testTwo() throws Exception {
        assertThat(FizzBuzz.translate(2)).isEqualTo("2");
    }

    @Test
    public void testThree() throws Exception {
        assertThat(FizzBuzz.translate(3)).isEqualTo("Fizz");
    }

    @Test
    public void testFive() throws Exception {
        assertThat(FizzBuzz.translate(5)).isEqualTo("Buzz");
    }

    @Test
    public void testFifteen() throws Exception {
        assertThat(FizzBuzz.translate(15)).isEqualTo("FizzBuzz");
    }
}
