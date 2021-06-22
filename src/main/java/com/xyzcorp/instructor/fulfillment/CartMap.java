package com.xyzcorp.instructor.fulfillment;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CartMap implements Cart {

    private final Map<Product, Integer> cartItems;

    public CartMap() {
        this.cartItems = new HashMap<>();
    }

    @Override
    public boolean contains(Product product) {
        return cartItems.containsKey(product);
    }

    @Override
    public void add(int quantity, Product product) {
        cartItems.computeIfPresent(product, (p, before) -> before + quantity);
        cartItems.putIfAbsent(product, quantity);
    }

    @Override
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    @Override
    public void reset() {
       cartItems.clear();
    }

    @Override
    public Optional<Integer> quantityFor(Product product) {
        return Optional.ofNullable(cartItems.get(product));
    }
}
