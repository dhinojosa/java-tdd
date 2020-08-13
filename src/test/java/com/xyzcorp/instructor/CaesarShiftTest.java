package com.xyzcorp.instructor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CaesarShiftTest {

    //("Foo" -> +5) -> "Ktt"
    //1. String result = CaesarShift.encode("Foo", 5);
    //   String result = CaesarShift.decode("Ktt", 5);
    //
    //2. CaesarShift cs = new CaesarShift();
    //   String result = cs.encode("Foo", 5);
    //   String result = cs.decode("Ktt", 5);
    //
    //3. CaesarShift cs = new CaesarShift(5);
    //   String result = cs.encode("Foo");
    //   String result = cs.decode("Ktt");
    //
    //4. CaesarShift ce = new CaesarShiftEncoder("Foo", 5);
    //   String result = cs.encode();
    //   CaesarShift cd = new CaesarShiftDecoder("Ktt", 5);
    //   String result = cd.encode();

    @Test
    @DisplayName("Encoding should work with empty string and zero")
    public void testEncodeWithEmptyStringAndZero() {
        String result = CaesarShift.encode("", 0);
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Encoding should accept an 'a' and still be an 'a' with 0 shift")
    public void testEncodeWithAnSmallAAndZero() {
        String result = CaesarShift.encode("a", 0);
        assertThat(result).isEqualTo("a");
    }

    @Test
    public void testEncodeWithAnSmallAAndOne() {
        String result = CaesarShift.encode("a", 1);
        assertThat(result).isEqualTo("b");
    }

    @Test
    public void testEncodeWithAnSmallBAndOne() {
        String result = CaesarShift.encode("b", 1);
        assertThat(result).isEqualTo("c");
    }

    @Test
    public void testStringIsNullClassic() {
        try {
            CaesarShift.encode(null, 1);
            fail("This line should never be evaluated");
        } catch (NullPointerException npe) {
            assertThat(npe).hasMessage("null is not a valid input");
        }
    }

    @Test
    void testStringIsNullLambda() {
        assertThatThrownBy(() -> CaesarShift.encode(null, 1))
            .hasMessage("null is not a valid input");
    }

    @Test
    void testWeirdCharactersAreIgnored() {
        String result = CaesarShift.encode("*", 1);
        assertThat(result).isEqualTo("*");
    }

    @Test
    void testEncodeWithLetterSmallZWithShiftOf1() {
        String result = CaesarShift.encode("z", 1);
        assertThat(result).isEqualTo("a");
    }

    @Test
    void testEncodeWithLetterSmallYWithShiftOf2() {
        String result = CaesarShift.encode("y", 2);
        assertThat(result).isEqualTo("a");
    }

    @Test
    void testEncodeCapitalAWithAShiftOf1() {
        String result = CaesarShift.encode("A", 1);
        assertThat(result).isEqualTo("B");
    }

    //Green Bar
    @Test
    void testEncodeCapitalBWithAShiftOfNegative1() {
        String result = CaesarShift.encode("B", -1);
        assertThat(result).isEqualTo("A");
    }

    @Test
    void testEncodeCapitalAWithZShiftOfNegative1() {
        String result = CaesarShift.encode("A", -1);
        assertThat(result).isEqualTo("Z");
    }

    @Test
    void testMoreThanOneLetter() {
        String result = CaesarShift.encode("AB", 1);
        assertThat(result).isEqualTo("BC");
    }

}
