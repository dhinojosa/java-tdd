package com.xyzcorp.student;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {
    @Test
    void test1() {
        String actual = FizzBuzz.convert(1);
        assertThat(actual).isEqualTo("1");
    }
    
    @Test
    void test3() {
        String actual = FizzBuzz.convert(3);
        assertThat(actual).isEqualTo("Fizz");
    }
    
    //Green Bar
    @Test
    void test4() {
        String actual = FizzBuzz.convert(4);
        assertThat(actual).isEqualTo("4");
    }
    
    @Test
    void test5() {
        String actual = FizzBuzz.convert(5);
        assertThat(actual).isEqualTo("Buzz");
    }
    
    @Test
    void test15() {
        String actual = FizzBuzz.convert(15);
        assertThat(actual).isEqualTo("FizzBuzz");
    }
    
    //Green Bar
    @Test
    void test30() {
        String actual = FizzBuzz.convert(30);
        assertThat(actual).isEqualTo("FizzBuzz");
    }
    
}
