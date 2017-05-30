package com.evolutionnext;

import com.google.common.base.Preconditions;

import java.util.stream.Collectors;

/**
 * Caesar shift encoder class
 * <p/>
 * <p/> - Works for A-Z and a-z
 * <p/> - Leaves all the other characters unmodified
 *
 * @author Mihai Bojin &lt;mbojin@salesforce.com&gt;
 * @since 1.0
 */
public class CaesarShift {
    private final static int ALPHABET_SIZE = 26;
    public final int shift;

    public CaesarShift(int shift) {
        this.shift = shift;
    }

    public String encrypt(String message) {
        Preconditions.checkNotNull(message);

        return message.chars().boxed()

                // lowercase
                .map(c -> c - 97)
                .map(this::encode)
                .map(c -> c + 97)

                // uppercase
                .map(c -> c - 65)
                .map(this::encode)
                .map(c -> c + 65)

                // convert back to Character
                .map(c -> Character.toString((char)c.intValue()))

                // collect back to String
                .collect(Collectors.joining());
    }

    /**
     * Encode if a-z or A-Z or return the input character
     */
    private Integer encode(int inputChar) {
        return shouldEncode(inputChar)?Math.floorMod(shift + inputChar, ALPHABET_SIZE):inputChar;
    }

    /**
     * Returns true if the character is between positions 0-26
     */
    private static boolean shouldEncode(int inputChar) {
        return (inputChar >= 0) && (inputChar <= ALPHABET_SIZE);
    }
}
