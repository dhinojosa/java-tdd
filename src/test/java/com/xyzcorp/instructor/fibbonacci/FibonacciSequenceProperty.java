package com.xyzcorp.instructor.fibbonacci;

import com.xyzcorp.instructor.fibonacci.FibonacciSequence;
import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Label("Fibonacci Sequence Properties")
public class FibonacciSequenceProperty {

    static Logger logger = LoggerFactory.getLogger(FibonacciSequenceProperty.class);

    @Property
    @Label("F(n) > n where n > 5")
    public void resultShouldBeGreaterThanTheNumberThatItStarted
        (@ForAll @IntRange(min = 6, max = 34) int i) {
        Assertions.assertThat(FibonacciSequence.apply(i)).isGreaterThan(i);
    }

    @Property
    @Label("F(n) = F(n-1) + F(n-2)")
    public void resultShouldBeSumFibMinus1FibMinus2
        (@ForAll @IntRange(min = 2, max = 34) int i) {
        logger.debug(Integer.toString(i));
        assertThat(FibonacciSequence.apply(i)).isEqualTo(FibonacciSequence.apply(i-1) + FibonacciSequence.apply(i - 2));
    }
}
