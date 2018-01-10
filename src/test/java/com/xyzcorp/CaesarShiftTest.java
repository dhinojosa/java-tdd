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
		         .hasMessage("String is null")
				.isInstanceOf(NullPointerException.class);
	}

	@Test
	public void testEncodeWithAFunctionAfter() {
		CaesarShift cs = new CaesarShift(1);
		assertThatThrownBy(() -> cs.encode(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("String is null");
	}

	@Test
	public void testEncodeWithANumberWithAShiftOf1() {
	    CaesarShift cs = new CaesarShift(1);
	    assertThat(cs.encode("2")).isEqualTo("2");
	}

	@Test
	public void testEncodeWithATwoNumbersWithAShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("25")).isEqualTo("25");
	}

	//Green Bar
	@Test
	public void testEncodeWithATwoStrangeCharactersWithAShiftOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("~1")).isEqualTo("~1");
	}

	@Test
	public void testEncodeWithABWithAShift1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("ab")).isEqualTo("bc");
	}

	@Test
	public void testEncodeWithAZWithAShift1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("z")).isEqualTo("a");
	}

	@Test
	public void testEncodeWithAZWithAShift27() {
		CaesarShift cs = new CaesarShift(27);
		assertThat(cs.encode("z")).isEqualTo("a");
	}

	@Test
	public void testEncodeWithAZWithAShift261() {
		CaesarShift cs = new CaesarShift(261);
		assertThat(cs.encode("z")).isEqualTo("a");
	}

	@Test
	public void testEncodeWithCapAAWithAShift0() {
		CaesarShift cs = new CaesarShift(0);
		assertThat(cs.encode("A")).isEqualTo("A");
	}

	@Test
	public void testEncodeWithCapZWithAShift1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("Z")).isEqualTo("A");
	}

	//Green Bar
	@Test
	public void testEncodeWithCapZWithAShift1IgnoreCase() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("Z")).isEqualToIgnoringCase("a");
	}

	//Green Bar
	@Test
	public void testEncodeWithNegative1() {
		CaesarShift cs = new CaesarShift(-1);
		assertThat(cs.encode("Z")).isEqualTo("Y");
	}

	@Test
	public void testEncodeAWithNegative1() {
		CaesarShift cs = new CaesarShift(-1);
		assertThat(cs.encode("A")).isEqualTo("Z");
	}

	@Test
	public void testEncodeAWithNegative27() {
		CaesarShift cs = new CaesarShift(-27);
		assertThat(cs.encode("A")).isEqualTo("Z");
	}

	@Test
	public void testDecodeAAOf1() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.decode("A")).isEqualTo("Z");
	}

	//GreenBar
	@Test
	public void testEncodeHelloWorld() {
		CaesarShift cs = new CaesarShift(5);
		System.out.println(cs.encode("Como estás! Mundo!"));
	}

	// Write a lot of tests
	// Small functions specific, signatures change (!)
}
