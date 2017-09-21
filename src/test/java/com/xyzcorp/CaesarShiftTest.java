package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.rules.ExpectedException;

public class CaesarShiftTest {

    @Test
    public void testEncodeOfShiftOf0AndEmptyString() {
        String result = CaesarShift.encode("", 0);
        assertEquals("", result);
    }

    @Test
    public void testEncodeOfShiftOf0AndStringOfSmallA() {
        String result = CaesarShift.encode("a", 0);
        assertThat(result).isEqualTo("a");
    }

    @Test
    public void testEncodeOfShiftOf1AndStringOfSmallA() {
        String result = CaesarShift.encode("a", 1);
        assertThat(result).isEqualTo("b");
    }

    @Test
    public void testShiftOf1AndStringOfZ() {
        assertThat(CaesarShift.encode("z", 1)).isEqualTo("a");
    }

    //GreenBar
    @Test
    public void testShiftOf26x4AndStringOfZ() {
        assertThat(CaesarShift.encode("g", 26 * 4)).isEqualTo("g");
    }

    @Test
    public void testTwoCharactersAndShift0() {
        assertThat(CaesarShift.encode("ab", 0)).isEqualTo("ab");
    }

    @Test
    public void testTwoCharactersAndShift1() {
        assertThat(CaesarShift.encode("ab", 1)).isEqualTo("bc");
    }

    @Test
    public void testNullForStringUsingClassicMethod() {
        try {
            CaesarShift.encode(null, 0);
            fail("This line should be invoked");
        } catch (NullPointerException npe) {
            assertThat(npe).hasMessage("String cannot be null"); //assertj
        }
    }

    //Junit 4
    //    @Rule
    //    public ExpectedException exception = ExpectedException.none();
    //
    //    @Test
    //    public void testNullForStringUsingJunit4Rule() {
    //        exception.expect(NullPointerException.class);
    //        exception.expectMessage("String cannot be null");
    //        CaesarShift.encode(null, 0);
    //    }

    //Green Bar
    @Test
    public void testNullForStringUsingAssertJ() {
        assertThatThrownBy(() -> CaesarShift.encode(null, 0))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("String cannot be null");
    }

    //Green Bar
    @Test
    public void testNullForStringUsingJUnit5() {
        NullPointerException npe =
                assertThrows(NullPointerException.class,
                        () -> CaesarShift.encode(null, 0));
        assertThat(npe).hasMessage("String cannot be null");
    }

    @Test
    public void testWithCapitalLetters()
    {
        assertThat(CaesarShift.encode("A", 1)).isEqualTo("B");
    }

    @Test
    public void testNonEssentialChars() {
        assertThat(CaesarShift.encode("~", 10)).isEqualTo("~");
    }


    //Green Bar
    @Test
    public void testFullSentence() {
        assertThat(CaesarShift.encode("Hello, World!", 1))
                              .isEqualTo("Ifmmp, Xpsme!");
    }

    @Test
    public void testDecodeWithEmptyStringAnd0() {
        assertThat(CaesarShift.decode("", 0)).isEqualTo("");
    }

    @Test
    public void testDecodeWithNonEmptyStringAnd0() {
        assertThat(CaesarShift.decode("a", 0)).isEqualTo("a");
    }

    @Test
    public void testDecodeWithStringOfFAnd1() {
        assertThat(CaesarShift.decode("f", 1)).isEqualTo("e");
    }

    //Difficulty LEVEL 12!
    @Test
    public void testDecodeWithStringOfAAnd1() {
        assertThat(CaesarShift.decode("a", 1)).isEqualTo("z");
    }

    @Test
    public void testDecodeWithStringOfAAnd26Times4Plus1() {
        assertThat(CaesarShift.decode("a", (26 * 4) + 1)).isEqualTo("z");
    }


    @Test
    public void testEncodeStringWithAsianCharacter() {
        assertThat(CaesarShift.decode("a", (26 * 4) + 1)).isEqualTo("z");
    }
}
