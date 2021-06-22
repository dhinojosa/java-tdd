package com.xyzcorp.instructor.fulfillment;

import java.util.Optional;

public interface Cart {
    boolean contains(Product product);

    void add(int quantity, Product product);

    boolean isEmpty();

    void reset();

    Optional<Integer> quantityFor(Product product);
}
