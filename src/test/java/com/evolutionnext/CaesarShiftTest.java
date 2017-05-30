package com.evolutionnext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CaesarShiftTest {
   @Test
   public void testEmptyStringWithShift0() {
	   CaesarShift caesarShift = new CaesarShift(0);
	   assertEquals("", caesarShift.encrypt(""));
   }

    @Test
    public void testEmptyStringWithShift4() {
        CaesarShift caesarShift = new CaesarShift(4);
        assertEquals("", caesarShift.encrypt(""));
    }

    //Non-Red
    @Test
    public void testASingleCharStringWithShift0() {
        CaesarShift caesarShift = new CaesarShift(0);
        assertEquals("a", caesarShift.encrypt("a"));
    }

    @Test
    public void testASingleCharStringWithShift1() {
        CaesarShift caesarShift = new CaesarShift(1);
        assertThat(caesarShift.encrypt("a")).isEqualTo("b");
    }

    @Test
    public void testAZetiCharWithShift1() {
        CaesarShift caesarShift = new CaesarShift(1);
        assertThat(caesarShift.encrypt("z")).isEqualTo("a");
    }

    //RedBar!
    @Test
    public void testAZetiCharWithShift27() {
        CaesarShift caesarShift = new CaesarShift(27);
        assertThat(caesarShift.encrypt("z")).isEqualTo("a");
    }

    //Green Bar!
    @Test
    public void testAZetiCharWithShift26() {
        CaesarShift caesarShift = new CaesarShift(26);
        assertThat(caesarShift.encrypt("z")).isEqualTo("z");
    }

    @Test
    public void testAStringOfTwoCharactersWithShift1() {
        CaesarShift caesarShift = new CaesarShift(1);
        assertThat(caesarShift.encrypt("ab")).isEqualTo("bc");
    }

    @Test
    public void testACharOfCapitalAWithShift1() {
        CaesarShift caesarShift = new CaesarShift(1);
        assertThat(caesarShift.encrypt("Z")).isEqualTo("A");
    }

    @Test
    public void testANullEncryptSomewhatModernWay() {
       try {
           CaesarShift caesarShift = new CaesarShift(1);
           caesarShift.encrypt(null);
           fail();
       } catch (NullPointerException npe) {
           assertThat(npe.getMessage()).isEqualTo("String cannot be null");
       }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testANullWithJunit5Rule() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("String cannot be null");
        CaesarShift caesarShift = new CaesarShift(1);
        caesarShift.encrypt(null);
    }

    @Test
    public void testASpecialCharOfAtWithShiftOf4() {
        CaesarShift caesarShift = new CaesarShift(4);
        assertThat(caesarShift.encrypt("@")).isEqualTo("@");
    }

}
