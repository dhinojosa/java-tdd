package com.xyzcorp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CaesarShiftTest {

    @Test
    public void testEncodeZeroShiftAndEmptyString() {
        //input(1..many):
        //  string: message
        //  shift: number
        //output:
        //  string: encoded message

        CaesarShift cs = new CaesarShift(0);
        String actual = cs.encode("");
        assertEquals("", actual);
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIsZeroAndStringIsA() {
        CaesarShift cs = new CaesarShift(0);
        assertThat(cs.encode("a")).isEqualTo("a");
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIsOneAndStringIsSmallA() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.encode("a")).isEqualTo("b");
    }

    @Test
    public void testStringToEncodeIsNullRegardlessOfCountClassicWay() {
        CaesarShift cs = new CaesarShift(1);
        try {
            cs.encode(null);
            fail("We should not be here");
        } catch (NullPointerException npe) {
            assertThat(npe).hasMessage(CaesarShift.STRING_CANNOT_BE_NULL);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testStringToEncodeIsNullRegardlessOfCountWithExpected() {
        CaesarShift cs = new CaesarShift(1);
        cs.encode(null);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testStringToEncodeIsNullRegardlessOfCountExpectedException() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage(CaesarShift.STRING_CANNOT_BE_NULL);
        CaesarShift cs = new CaesarShift(1);
        cs.encode(null);
    }


    @Test
    public void testStringToEncodeIsNullRegardlessOfCountThrownBy() {
        CaesarShift cs = new CaesarShift(1);
        assertThatThrownBy(() -> cs.encode(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(CaesarShift.STRING_CANNOT_BE_NULL);
    }

    @Test
    public void testNonAlphabetCharacterLetItPassThrough() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.encode("!")).isEqualTo("!");
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIsOneAndStringIsSmallZ() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.encode("z")).isEqualTo("a");
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIsOneAndStringIsSmallX() {
        CaesarShift cs = new CaesarShift(4);
        assertThat(cs.encode("x")).isEqualTo("b");
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIsOneAsStringIsSmallAB() {
    	CaesarShift cs = new CaesarShift(1);
        assertThat(cs.encode("ab")).isEqualTo("bc");
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIsOneAndStringIsLargeA() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.encode("A")).isEqualTo("B");
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIs26AndStringIsLargeZ() {
        CaesarShift cs = new CaesarShift(26);
        assertThat(cs.encode("Z")).isEqualTo("Z");
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIsNegOneAndStringIsSmallA() {
        CaesarShift cs = new CaesarShift(-1);
        assertThat(cs.encode("a")).isEqualTo("z");
    }


    @Test
    public void testEncodeReturnsAStringWhenCountIsNegTwoAndStringIsSmallA() {
        CaesarShift cs = new CaesarShift(-2);
        assertThat(cs.encode("a")).isEqualTo("y");
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIsNegTwentySixAndStringIsSmallA() {
        CaesarShift cs = new CaesarShift(-26);
        assertThat(cs.encode("a")).isEqualTo("a");
    }

    @Test
    public void testEncodeReturnsAStringWhenCountIs26000AndStringIsSmallA() {
        CaesarShift cs = new CaesarShift(-26000);
        assertThat(cs.encode("a")).isEqualTo("a");
    }

    @Test
    public void testDecodeReturnsAStringWhenCountIs1AndStringIsEmpty() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.decode("")).isEqualTo("");
    }

    @Test
    public void testStringToDecodeIsNullRegardlessOfCountThrownBy() {
        CaesarShift cs = new CaesarShift(1);
        assertThatThrownBy(() -> cs.decode(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(CaesarShift.STRING_CANNOT_BE_NULL);
    }

    @Test
    public void testDecodeReturnsAStringWhenCountIs1AndStringIsSmallA() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.decode("a")).isEqualTo("z");
    }

    @Test
    public void testEncodeAndDecodeOfHelloWorld() {
        CaesarShift cs = new CaesarShift(50);
        assertThat(cs.decode(cs.encode("Hello World!"))).isEqualTo("Hello World!");
    }
}
