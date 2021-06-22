package com.xyzcorp.instructor.fulfillment;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CartMapTest {

    @Test
    void testIsEmptyIfNothingIsAdded() {
        CartMap cartMap = new CartMap();
        assertThat(cartMap.isEmpty()).isTrue();
    }

    @Test
    void testAddProductAndVerifyNonEmpty() {
        Product product = new Product("Hello Kitty Guitar");
        CartMap cartMap = new CartMap();
        cartMap.add(4, product);
        assertThat(cartMap.isEmpty()).isFalse();
    }

    @Test
    void testAddConsecutiveCallsToCartWithDifferentQuantitiesShouldBeAdditive() {
        Product product = new Product("Hello Kitty Guitar");
        CartMap cartMap = new CartMap();
        cartMap.add(4, product);
        cartMap.add(8, product);
        assertThat(cartMap.quantityFor(product)).contains(12);
    }

    @Test
    void testAddDifferentConsecutiveCallsToCartWithDifferentQuantitiesShouldBeAdditive() {
        Product product = new Product("Hello Kitty Guitar");
        CartMap cartMap = new CartMap();
        cartMap.add(10, product);
        cartMap.add(10, product);
        assertThat(cartMap.quantityFor(product)).contains(20);
    }

    @Test
    void testResetAfterItemsHaveBeenAdded() {
        Product product = new Product("Hello Kitty Guitar");
        CartMap cartMap = new CartMap();
        cartMap.add(10, product);
        cartMap.add(10, product);
        cartMap.reset();
        assertThat(cartMap.contains(product)).isFalse();
    }
}
