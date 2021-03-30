package com.xyzcorp.instructor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CaesarShiftTest {
    //ZOMBIES
    //Z = Zero
    //O = One
    //M = Many
    //B = Boundary
    //I = Interface Definition
    //E = Exception
    //S = Simple

    //Input: String we wish to encode
    //Input: Shift number
    //Output: Encoded String

    private static Stream<Arguments> caesarShiftProvider() {
        return Stream.of(
            Arguments.of("",  0,  ""),
            Arguments.of("a", 0, "a"),
            Arguments.of("a", 1, "b"),
            Arguments.of("b", 1, "c"), //Green
            Arguments.of("z", 1, "a")  //? Philosophy Time
        );
    }

    @ParameterizedTest(name = "{index}, original: {0}, shift:{1}, result:{2}")
    @MethodSource(value = {"caesarShiftProvider"})
    void testCaesarShiftEncode(String original, int shift, String result) {
        assertThat(CaesarShift.encode(original, shift)).isEqualTo(result);
    }

    @Test
    void testThatTheStringProvidedIsNotNull() {
        assertThatThrownBy(() -> CaesarShift.encode(null, 4))
            .isInstanceOf(NullPointerException.class)
            .hasMessage("String must not be null");
    }



    //2. Z, Z + 1,
    //3. A, A - 1
    //4. Emoji or weird chars
    //5. Multiples Letters
}
