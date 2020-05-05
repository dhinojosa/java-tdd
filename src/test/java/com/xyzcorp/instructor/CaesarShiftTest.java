package com.xyzcorp.instructor;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;


public class CaesarShiftTest {
    //Simplest Thing that I can do??
    //Input -> Output
    //(word, shift) -> word
    //("", 0) -> "" //Anchor

    @Test
    void testEmptyStringAndZero() {
        CaesarShift cs = new CaesarShift(0);
        String actual = cs.encode("");
        assertThat(actual).isEqualTo("");
    }

    @Test
    void testSingleCharAndZero() {
        CaesarShift cs = new CaesarShift(0);
        String actual = cs.encode("a");
        assertThat(actual).isEqualTo("a");
    }

    @Test
    void testSingleCharAndShiftOfOne() {
        CaesarShift cs = new CaesarShift(1);
        String actual = cs.encode("a");
        assertThat(actual).isEqualTo("b");
    }

    @Test()
    void testThatNullIsNotAccepted() {
        CaesarShift cs = new CaesarShift(1);
        try {
            cs.encode(null);
            fail("This code should not reach this point");
        } catch (NullPointerException npe) {
            assertThat(npe).hasMessage("Encode cannot accept null");
        }
    }

    @Test
    void testThatNullIsNotAcceptedAssertJWay() {
        CaesarShift cs = new CaesarShift(1);

        assertThatThrownBy(() -> cs.encode(null))
            .hasMessage("Encode cannot accept null");
    }

    @Test
    void testZWith26() { }
}
