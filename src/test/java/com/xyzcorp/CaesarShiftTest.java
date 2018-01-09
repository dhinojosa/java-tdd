package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.assertj.core.api.ThrowableAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.internal.matchers.Null;

public class CaesarShiftTest {

	@Test
	public void testEncodeEmptyStringAnd0Shift() {
		CaesarShift cs = new CaesarShift(0);
		assertEquals("", cs.encode(""));
	}

	@Test
	public void testEncodeAnAAnd0Shift() {
		CaesarShift cs = new CaesarShift(0);
		assertEquals("a", cs.encode("a"));
	}

	@Test
	public void testEncodeAnAAnd1Shift() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("a")).isEqualTo("b");
	}

	@Test
	public void testEncodeANullAnd1ShiftClassic() {
		CaesarShift cs = new CaesarShift(1);
		try {
			cs.encode(null);
			fail("This line should never be executed");
		} catch (NullPointerException npe) {
			assertThat(npe).hasMessage("String is null");
		}
	}

	@Test(expected = NullPointerException.class)
	public void testEncodeNullWithExpectedParameter() {
		CaesarShift cs = new CaesarShift(1);
		cs.encode(null);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testEncodeNullWithRule() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("String is null");
		CaesarShift cs = new CaesarShift(1);
		cs.encode(null);
	}

	@Test
	public void testEncodeWithAFunctionBefore() {
		CaesarShift cs = new CaesarShift(1);
		assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                cs.encode(null);
            }
        })
		         .hasMessage("String cannot be null")
				.isInstanceOf(NullPointerException.class);
	}

	@Test
	public void testEncodeWithAFunctionAfter() {
		CaesarShift cs = new CaesarShift(1);
		assertThatThrownBy(() -> cs.encode(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("String is null");
	}

	// Write a lot of tests
	// Small functions specific, signatures change (!)
}
