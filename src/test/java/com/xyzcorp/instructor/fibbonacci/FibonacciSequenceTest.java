package com.xyzcorp.instructor.fibbonacci;

import com.xyzcorp.instructor.fibonacci.FibonacciSequence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FibonacciSequenceTest {


    //f(n) -> 0 -> if n = 0
    //     -> 1 -> if n = 1
    //     -> F(n-1) + F(n - 2) if n > 1

    @Test
    public void testZero() {
        Assertions.assertThat(FibonacciSequence.apply(0)).isEqualTo(0);
    }

    @Test
    public void testOne() {
        assertThat(FibonacciSequence.apply(1)).isEqualTo(1);
    }

    @Test
    public void testNonNegative() {
        assertThatThrownBy(() -> FibonacciSequence.apply(-3)).hasMessage("Number cannot be negative");
    }

    @Test
    public void testTwo() {
        assertThat(FibonacciSequence.apply(2)).isEqualTo(FibonacciSequence.apply(1) + FibonacciSequence.apply(0));
    }

    @Test
    public void test34() {
        assertThat(FibonacciSequence.apply(34)).isEqualTo(5702887);
    }
}
