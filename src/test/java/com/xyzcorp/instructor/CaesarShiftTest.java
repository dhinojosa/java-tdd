package com.xyzcorp.instructor;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CaesarShiftTest {

    /**
     * Input: word(String)
     * Input: shift (int)
     * Output: word(String)
     * "", 0 -> ""
     */
    @Test
    public void testEncodeWithEmptyStringAndZero() {
        String result = CaesarShift.encode("", 0);
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testEncodeWithSmallAAndZero() {
        String result = CaesarShift.encode("a", 0);
        assertThat(result).isEqualTo("a");
    }

    @Test
    public void testEncodeWithSmallAAndShiftOf1() {
        String result = CaesarShift.encode("a", 1);
        assertThat(result).isEqualTo("b");
    }

    //GreenBar
    @Test
    public void testMoreThanOneCharacter() {
        String result = CaesarShift.encode("ab", 0);
        assertThat(result).isEqualTo("ab");
    }

    //GreenBar
    @Test
    public void testShiftLetterGWithShiftOf2() {
        String result = CaesarShift.encode("g", 2);
        assertThat(result).isEqualTo("i");
    }

    //GreenBar
    @Test
    public void testShiftWordLowerCaseGoCartWithShiftOf2() {
        String result = CaesarShift.encode("gocart", 2);
        assertThat(result).isEqualTo("iqectv");
    }

    @Test
    public void testStringIsNull() {
        try {
            CaesarShift.encode(null, 0);
            fail("This line should not be invoked");
        } catch (NullPointerException e) {
            assertThat(e).hasMessage("Word cannot be null");
        }
    }

    @Test
    public void testStringIsNullWithLambda() {
        assertThatThrownBy(() -> CaesarShift.encode(null, 0))
                .hasMessage("Word cannot be null")
                .isInstanceOf(NullPointerException.class);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testStringIsNullWithRule() {
        expectedException.expectMessage("Word cannot be null");
        expectedException.expect(NullPointerException.class);
        CaesarShift.encode(null, 0);
    }


    //4
    public void testNumbersAndSpecialCharacter() {}

    //5
    public void testSpaces() {}

    public void testZAndShiftOf1() {}

    public void testUpperCase() {}

    public void testNegativeShift() {}

    public void testShiftMoreThan26() {} //YIKES!!!

    public void testLessThanNegative26() {}

}
