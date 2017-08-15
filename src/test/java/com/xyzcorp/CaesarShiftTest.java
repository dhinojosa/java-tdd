package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

@Category(value = UnitTest.class)
public class CaesarShiftTest {
	// What are the easier inputs

	@Test
	public void testShiftOfEmptyStringAnd0() {
		CaesarShift cs = new CaesarShift(0);
		assertEquals("", cs.encode(""));
	}

	@Test
	public void testShiftOfZeroCharStringOfA() {
		CaesarShift cs = new CaesarShift(0);
		assertThat(cs.encode("a")).isEqualTo("a");
	}

	@Test
	public void testShiftOfOneCharStringOfA() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("a")).isEqualTo("b");
	}

	@Test
	public void testEncodeWithNullClassicForm() {
		CaesarShift cs = new CaesarShift(1);
		try {
			cs.encode(null);
			fail("This should not run");
		} catch (NullPointerException e) {
			assertThat(e).hasMessage(CaesarShift.STRING_CANNOT_BE_NULL);
		}
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// GreenBar
	@Test
	public void testEncodeWithAJUnitRule() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage(CaesarShift.STRING_CANNOT_BE_NULL);
		CaesarShift cs = new CaesarShift(1);
		cs.encode(null);
	}

	// GreenBar
	@Test
	public void testEncodeWithANullUsingAssertJFunction() {
		CaesarShift cs = new CaesarShift(1);
		assertThatThrownBy(() -> cs.encode(null))
				.isInstanceOf(NullPointerException.class)
				.hasMessage(CaesarShift.STRING_CANNOT_BE_NULL);
	}

	@Test
	public void testShiftOfOneCharStringOfZ() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("z")).isEqualTo("a");
	}

	@Test
	public void testShiftOfTwoCharStringOfX() {
		CaesarShift cs = new CaesarShift(2);
		assertThat(cs.encode("y")).isEqualTo("a");
	}

	@Test
	public void testShiftOf27CharStringOfZ() {
		CaesarShift cs = new CaesarShift(27);
		assertThat(cs.encode("z")).isEqualTo("a");
	}

	@Test
	public void testShiftOfNeg2CharStringOfA() {
		CaesarShift cs = new CaesarShift(-2);
		assertThat(cs.encode("a")).isEqualTo("y");
	}

	@Test
	public void testShiftOfNeg27CharStringOfA() {
		CaesarShift cs = new CaesarShift(-27);
		assertThat(cs.encode("a")).isEqualTo("z");
	}

	@Test
	public void testShiftOfOneCharStringOfCapA() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("A")).isEqualTo("B");
	}

	@Test
	public void testShiftOf0WithWithStrangeChar() {
		CaesarShift cs = new CaesarShift(0);
		assertThat(cs.encode("~")).isEqualTo("~");
	}

	@Test
	public void testDecodeShiftOfEmptyStringAnd0() {
		CaesarShift cs = new CaesarShift(0);
		assertEquals("", cs.decode(""));
	}

	@Test
	public void testDecodeShiftOfZeroCharStringOfA() {
		CaesarShift cs = new CaesarShift(0);
		assertThat(cs.decode("a")).isEqualTo("a");
	}

	@Test
	public void testDecodeShiftOfOneCharStringOfA() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.decode("a")).isEqualTo("z");
	}

	@Test
	public void testEncodeShiftOfATwoLetterWordStringOfA() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("ab")).isEqualTo("bc");
	}

	@Test
	public void testDecodeShiftOfATwoLetterWordStringOfA() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.decode("ab")).isEqualTo("za");
	}

	// GreenBar
	@Test
	public void testHelloWorldEncode() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.encode("Hello World!")).isEqualTo("Ifmmp Xpsme!");
	}

	// GreenBar
	@Test
	public void testHelloWorldDecode() {
		CaesarShift cs = new CaesarShift(1);
		assertThat(cs.decode(cs.encode("Hello World!"))).isEqualTo("Hello World!");
	}
}
