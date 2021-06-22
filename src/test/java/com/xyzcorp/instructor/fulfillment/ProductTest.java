package com.xyzcorp.instructor.fulfillment;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductTest {

    @Test
    void testProductNameAttribute() {
        Product product = new Product("Foo");
        assertThat(product.getName()).isEqualTo("Foo");
    }

    @Test
    void testProductNameCannotBeNull() {
        assertThatThrownBy(() -> new Product(null))
            .isInstanceOf(NullPointerException.class)
            .hasMessage("Name cannot be null");
    }

    @Test
    void testProductNameCannotBeEmpty() {
        assertThatThrownBy(() -> new Product(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Name cannot be blank");
    }



}
