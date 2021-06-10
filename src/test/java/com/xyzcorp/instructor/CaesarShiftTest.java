package com.xyzcorp.instructor;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class CaesarShiftTest {
    //ZOMBIES
    //Do the simplest or small things first...
    //Z = Zero
    //O = One
    //M = Many
    //B = Boundary
    //I = Interface (Filler)
    //E = Exceptions
    //S = Simple (Filler)

    private static Stream<Arguments> stringShiftProvider() {
        return Stream.of(
            Arguments.of("", 0, ""),
            Arguments.of("a", 0, "a"),
            Arguments.of("a", 1, "b"),
            Arguments.of("a", 2, "c"), //GreenBar?
            Arguments.of("g", 2, "i"), //GreenBar?
            Arguments.of("z", 1, "a")
        );
    }

    @Test
    void testForStringIsNull() {
        CaesarShift cs = new CaesarShift(3);
        assertThatThrownBy(() -> cs.encode(null))
            .isInstanceOf(NullPointerException.class)
            .hasMessage("String cannot be null");
    }

    @ParameterizedTest(name= "{index}: str={0}, shift={1}, expected={2}")
    @MethodSource("stringShiftProvider")
    void testEncodeWithParameters(String str, int shift, String expected) {
        CaesarShift cs = new CaesarShift(shift);
        String actual = cs.encode(str);
        assertThat(actual).isEqualTo(expected);
    }
}
