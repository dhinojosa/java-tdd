package com.xyzcorp.instructor.fulfillment;

import java.util.Objects;
import java.util.StringJoiner;

public class Product {
    private final String name;

    public Product(String name) {
        Objects.requireNonNull(name, "Name cannot be null");
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be blank");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .toString();
    }
}
