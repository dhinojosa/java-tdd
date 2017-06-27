package com.xyzcorp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CaesarShiftTest {

    private CaesarShift caesarShiftZero;

    @Before
    public void setUp() {
        caesarShiftZero = new CaesarShift(0);
    }

    // Choose the simplest thing to tackle first.
    @Test
    public void testEmptyStringWithShiftOf0() {
        //What do I want my API to look like?
        assertThat(caesarShiftZero.encode("")).isEqualTo("");
    }

    @Test
    public void testEmptyStringWithShiftOf1() {
        //What do I want my API to look like?
        CaesarShift cs = new CaesarShift(1);
        assertEquals("", cs.encode(""));
    }

    @Test
    public void testAStringOfOneCharacterWithShiftOf0() {
        //What do I want my API to look like?
        assertEquals("a", caesarShiftZero.encode("a"));
    }

    @Test
    public void testAStringOfOneCharacterWithShiftOf1() {
        //What do I want my API to look like?
        CaesarShift cs = new CaesarShift(1);
        assertEquals("b", cs.encode("a"));
    }

    @Test
    public void testAStringOfOneCharacterWithShiftOf1FromZ() {
        //What do I want my API to look like?
        CaesarShift cs = new CaesarShift(1);
        assertEquals("a", cs.encode("z"));
    }


    @Test
    public void testAStringOfOneCharacterWithShiftOf27FromZ() {
        //What do I want my API to look like?
        CaesarShift cs = new CaesarShift(27);
        assertEquals("a", cs.encode("z"));
    }

    @Test
    public void testAStringOfOneCharacter104() {
        //What do I want my API to look like?
        CaesarShift cs = new CaesarShift(104);
        assertEquals("a", cs.encode("a"));
    }

    @Test
    public void testAStringOfOneCapitalAAndAShiftOf3() {
        //What do I want my API to look like?
        CaesarShift cs = new CaesarShift(3);
        assertThat(cs.encode("Z")).isEqualTo("C");
    }

    @Test
    public void testEncodeWithANullClassicWay() {
        CaesarShift cs = new CaesarShift(3);
        try {
            cs.encode(null);
            fail("This line should not run");
        } catch (NullPointerException npe) {
            assertThat(npe).hasMessage("String cannot be null");
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testEncodeWithANullUsingAJUnitRule() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("String cannot be null");
        CaesarShift cs = new CaesarShift(3);
        cs.encode(null);
    }

    @Test
    public void testEncodeWithANullUsingAAssertJFunction() {
        CaesarShift cs = new CaesarShift(3);
        assertThatThrownBy(() -> cs.encode(null))
                .hasMessage("String cannot be null")
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testTwoLettersByAShiftOf1() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.encode("ab")).isEqualTo("bc");
    }

    @Test
    public void testSomethingThatIsNotAlphaWithAShift1() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.encode("~")).isEqualTo("~");
    }

    @Test
    public void testADecodeWithASingleCharacterOfSmallB() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.decode("b")).isEqualTo("a");
    }

    @Test
    public void testADecodeWithASingleCharacterOfSmallC() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.decode("c")).isEqualTo("b");
    }

    @Test
    public void testADecodeWithASingleCharacterOfSmallA() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.decode("a")).isEqualTo("z");
    }

    //NoRedBar
    @Test
    public void testProperty() {
        CaesarShift cs = new CaesarShift(1);
        assertThat(cs.decode(cs.encode("Hello, World!"))).isEqualTo("Hello, World!");
    }

    //NoRedBar
    @Test
    public void testEncodeANegative() {
        CaesarShift cs = new CaesarShift(-1);
        assertThat(cs.encode("a")).isEqualTo("z");
    }

    //NoRedBar
    @Test
    public void testDecodeANegative() {
        CaesarShift cs = new CaesarShift(-1);
        assertThat(cs.decode("z")).isEqualTo("a");
    }

    //NoRedBar
    @Test
    public void testDecodeWith261() {
        CaesarShift cs = new CaesarShift(261);
        assertThat(cs.decode("a")).isEqualTo("z");
    }

    @Test
    public void testDecodeWith26() {
        CaesarShift cs = new CaesarShift(26);
        assertThat(cs.decode("z")).isEqualTo("z");
    }


    //Maybe not enough for ñ

}
