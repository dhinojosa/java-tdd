package com.xyzcorp.instructor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaesarShiftTest {

    //Simplest Input and Output
    //Input: ("":String),(0:Int)
    //Output: ""

    @Test
    public void testEncodeWithEmptyStringAndShiftOf0() {
        String result = CaesarShift.encode("", 0);
        assertEquals("", result);
    }
    
    @Test
    public void testEncodeWithSmallAAndShiftOf0() {
    	String result = CaesarShift.encode("a", 0);
    	assertEquals("a", result);
    }

    @Test
    public void testEncodeWithSmallAAndShiftOf1() {
        String result = CaesarShift.encode("a", 1);
        assertEquals("b", result);
    }

    //test for shift of 0
}
