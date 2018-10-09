package com.xyzcorp.instructor;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class CaesarShiftTest {

    //Simplest Input and Output
    //Input: ("":String),(0:Int)
    //Output: ""

    @Test
    public void testEncodeWithEmptyStringAndShiftOf0() {
        assertEquals("", CaesarShift.encode("", 0));
    }
    
    @Test
    public void testEncodeWithSmallAAndShiftOf0() {
    	assertEquals("a", CaesarShift.encode("a", 0));
    }

    @Test
    public void testEncodeWithSmallAAndShiftOf1() {
        assertThat(CaesarShift.encode("a", 1)).isEqualTo("b");
    }
    
    @Test
    public void testEncodeWithNullAsAStringClassicWay() {
    	try {
    		CaesarShift.encode(null, 0);
    		fail("This line should not run");
    	} catch (NullPointerException npe) {
    		assertEquals("String cannot be null", npe.getMessage());
    	}
    }
    
    /**
     * Do not do it this way
     */
    @Test(expected = NullPointerException.class)
    public void testEncodeWithNullAsAStringUsingExpectedAnnotation() {
    	CaesarShift.encode(null, 0);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testEncodeWithNullAsAStringUsingRule() {
        expectedException.expectMessage("String cannot be null");
        expectedException.expect(NullPointerException.class);
        CaesarShift.encode(null, 0);
    }

    @Test
    public void testEncodeWithNullAsAStringUsingAssertJLambdas() {
        assertThatThrownBy(() -> CaesarShift.encode(null, 0))
                .hasMessage("String cannot be null")
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testSpecialCharactersWithExclamationMark() {
        assertThat(CaesarShift.encode("!", 1)).isEqualTo("!");
    }
    
    //Green bar
    @Test
    public void testSpecialCharactersWithAtSign() {
        assertThat(CaesarShift.encode("@", 1)).isEqualTo("@");
    }

    @Test
    public void testEncodeWithASmallLetterWithAShiftOf1() {
        assertThat(CaesarShift.encode("z", 1)).isEqualTo("a");
    }

    @Test
    public void testEncodeWithTwoSmallLettersWithAShiftOf1() {
        assertThat(CaesarShift.encode("ab", 1)).isEqualTo("bc");
    }

    //Green Bar!
    @Test
    public void testEncodeWithASmallBAndNegative1() {
        assertThat(CaesarShift.encode("b", -1)).isEqualTo("a");
    }

    @Test
    public void testEncodeWithASmallAAndNegative1() {
        assertThat(CaesarShift.encode("a", -1)).isEqualTo("z");
    }

    @Test
    public void testEncodeWithACapitalAAnd1() {
        assertThat(CaesarShift.encode("A", 1)).isEqualTo("B");
    }

    //Green Bar
    @Test
    public void testEncodeWithACapitalAAnd26() {
        assertThat(CaesarShift.encode("A", 26)).isEqualTo("A");
    }

    @Test
    public void testEncodeWithACapitalAAnd2600() {
        assertThat(CaesarShift.encode("A", 2600)).isEqualTo("A");
    }

    @Test
    public void testEncodeWithACapitalAAndNeg2600() {
        assertThat(CaesarShift.encode("A", -2600)).isEqualTo("A");
    }

    @Test
    public void testDecodeWithAnEmptyStringAndZero() {
        assertThat(CaesarShift.decode("", 0)).isEqualTo("");
    }

    //Green Bar Test
    @Test
    public void testDecodeWithNull() {
        assertThatThrownBy(() -> CaesarShift.decode(null, 0))
                .hasMessage("String cannot be null")
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testDecodeWithAnCapitalAAnd1() {
        assertThat(CaesarShift.decode("A", 1)).isEqualTo("Z");
    }

    //green bar test
    @Test
    public void testEncodeAndDecodeOfHelloWorld() {
        int shift = 10;
        String result = CaesarShift.decode(CaesarShift.encode("Hello, World", shift), shift);
        assertThat(result).isEqualTo("Hello, World");
    }

//    @Test
//    public void testGreekLetters() {
//        assertThat(CaesarShift.encode("Δ", 1)).isEqualTo("Δ");
//    }
}
