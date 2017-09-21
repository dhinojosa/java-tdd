package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PersonTest {

	@Test
	void testPersonEquality() {
		Person person = new Person("Howard Smith");
		Person person2 = new Person("Howard Smith");
		assertThat(person).isEqualTo(person2);
	}


	@Test
	void testPersonProperty() {
		Person person = new Person("Howard Smith");
		assertThat(person.getName()).isEqualTo("Howard Smith");
	}

	@Test
	void testPersonHashCode() {
		Person person = new Person("Howard Smith");
		Person person2 = new Person("Howard Smith");
		assertThat(person.hashCode()).isEqualTo(person2.hashCode());
	}

	//You have more work to do...
}
