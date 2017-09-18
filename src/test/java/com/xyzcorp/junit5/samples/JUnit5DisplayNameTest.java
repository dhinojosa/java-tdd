package com.xyzcorp.junit5.samples;

import org.junit.jupiter.api.*;

public class JUnit5DisplayNameTest {
    class DisplayNameDemo {

        @Test
        @DisplayName("Custom test name containing spaces")
        public void testWithDisplayNameContainingSpaces() {
        }

        @Test
        @DisplayName("╯°□°）╯")
        public void testWithDisplayNameContainingSpecialCharacters() {
        }

        @Test
        @DisplayName("😱")
        public void testWithDisplayNameContainingEmoji() {
        }
    }
}
