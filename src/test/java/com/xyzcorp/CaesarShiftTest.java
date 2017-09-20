package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CaesarShiftTest {
    /* Do the simplest thing first*/
    @Test
    public void testEncodeEmptyStringWithAShiftOf0() {
        CaesarShift cs = new CaesarShift(0);
        String result = cs.encode("");
        assertEquals("", result);
    }

    @Test
    public void testEncodeSingleCharacterWithAShiftOf0() {
        CaesarShift cs = new CaesarShift(0);
        String result = cs.encode("a");
        assertEquals("a", result);
    }

    @Test
    public void testEncodeSingleCharacterWithAShiftOf1() {
        CaesarShift cs = new CaesarShift(1);
        String result = cs.encode("a");
        assertEquals("b", result);
    }

    @Test
    void testEncodeWithNullClassicMethod() {
        CaesarShift cs = new CaesarShift(1);
        try {
            cs.encode(null);
            fail("Was not expecting this line to run");
        } catch (NullPointerException e) {
            assertEquals("String cannot be null", e.getMessage());
        }
    }

    @Test
    public void testEncodeWithNullUsingAssertJ() {
        CaesarShift cs = new CaesarShift(1);
        assertThatThrownBy(() -> cs.encode(null))
           .hasMessage("String cannot be null");
    }

    @Test
    public void testEncodeWithNullUsingJUnit5() {
        CaesarShift cs = new CaesarShift(1);
        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> cs.encode(null));
        assertEquals("String cannot be null",
                nullPointerException.getMessage());
    }
    @Test
    void testWhatHappensToZShiftOf2() {
        CaesarShift cs = new CaesarShift(2);
        String result = cs.encode("z");
        assertEquals("b", result);
    }

    @Test
    void testWhatHappensToZShiftOf28() {
        CaesarShift cs = new CaesarShift(28);
        String result = cs.encode("z");
        assertEquals("b", result);
    }

    void testEncodeCharacterThatNotSupported() {
    }

    void testMoreThanOneCharacter() {
    }

    void testForUpperCaseCharacter() {
    }

    void testNegativeShift() {
    }

    void testDecode() {
    }

    void testDecodeWithShiftOfAAnd4() {
    }
}
