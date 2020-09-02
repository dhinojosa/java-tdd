package com.xyzcorp.instructor;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CaesarShiftTest {

    //Simple
    //Think about API

    //Input: string:String, shift:Int
    //Output: string:String

    //How? Api?
    //1. CaesarShift.encode(str, shift)
    //2. CaesarShift cs = new CaesarShift(shift);
    //   cs.encode(str);
    //3. CaesarShift cs = new CaesarShift();
    //   cs.encode(str, shift); :(
    //...

//    @Test
//    void testEncodeWithEmptyStringShiftOf0() {
//        CaesarShift caesarShift = new CaesarShift(0);
//        String result = caesarShift.encode("");
//        assertThat(result).isEmpty();
//    }


    private static Stream<Arguments> stringIntAndStringAnswerProvider() {
        return Stream.of(
            Arguments.of("", 0, ""),
            Arguments.of("a", 0, "a"),
            Arguments.of("a", 1, "b"),
            Arguments.of("a", 2, "c"),  //Green
            Arguments.of("z", 1, "a"),
            Arguments.of("ab", 1, "bc")
        );
    }

    @ParameterizedTest(name = "{index}: original={0}, shift={1}, encoded={2}")
    @MethodSource("stringIntAndStringAnswerProvider")
    void testEncodeWithDifferentArguments(String str, int num,
                                          String expected) {
        CaesarShift caesarShift = new CaesarShift(num);
        String actual = caesarShift.encode(str);
        assertThat(actual).isEqualTo(expected);
    }


    @Test
    void testThatStringIsNotANull() {
        CaesarShift caesarShift = new CaesarShift(3);
        assertThatThrownBy(() -> caesarShift.encode(null))
            .isInstanceOf(NullPointerException.class)
            .hasMessage("Encode cannot accept a null String");
    }
}
