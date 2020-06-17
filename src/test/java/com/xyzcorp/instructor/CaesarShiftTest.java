package com.xyzcorp.instructor;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CaesarShiftTest {
    //Simplest Test Case
    // Input: (string, shift)
    // Output: (string)
    // "", 0 -> ""


    @Test
    void testEncodingWithEmptyStringAndZero() {
        String result = CaesarShift.encode("", 0);
        assertThat(result).isEqualTo("");
    }

    @Test
    void testEncodingWithSingleCharacterStringAnd0() {
        String result = CaesarShift.encode("a", 0);
        assertThat(result).isEqualTo("a");
    }

    @Test
    void testEncodingWithSingleCharacterStringAnd1() {
        String result = CaesarShift.encode("a", 1);
        assertThat(result).isEqualTo("b");
    }

    @Test()
    void testEncodingWithNullString() {
        try {
            CaesarShift.encode(null, 1);
            fail("This line should not be called");
        } catch (NullPointerException npe) {
            assertThat(npe).hasMessage("String cannot be null");
        }
    }

    //GreenBar
    @Test
    void testEncodingWithNullStringTheModernWay() {
        assertThatThrownBy(
            () -> CaesarShift.encode(null, 1))
            .hasMessage("String cannot be null");
    }

}
