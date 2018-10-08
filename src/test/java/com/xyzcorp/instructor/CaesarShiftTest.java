package com.xyzcorp.instructor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    // 'he' -> + 1 -> if
    // Greek Letters or anything else that is a letter.
    // Capital letter


    //I don't know to do about Greek Letters...
//    @Test
//    public void testSpecialCharactersWithAUnicodeThatIsNotStandardAscii() {
//        assertThat(CaesarShift.encode("Δ", 1)).isEqualTo("Δ");
//    }
}
