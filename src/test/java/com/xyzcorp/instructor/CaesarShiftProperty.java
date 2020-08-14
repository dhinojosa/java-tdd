package com.xyzcorp.instructor;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;

import static org.assertj.core.api.Assertions.assertThat;

public class CaesarShiftProperty {
    @Property
    public void testThatEncodeThenDecodeIsTheOriginal(
        @ForAll @AlphaChars String string, @ForAll int shift
    ) {
        System.out.format("string: %s, shift: %d\n", string, shift);
        String decode = CaesarShift
            .decode(CaesarShift.encode(string, shift), shift);
        assertThat(decode).isEqualTo(string);
    }
}
