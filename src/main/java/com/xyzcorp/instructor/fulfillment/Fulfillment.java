package com.xyzcorp.instructor.fulfillment;

import java.util.function.Supplier;

//Subject under test
public class Fulfillment {
    private final Supplier<Cart> cartSupplier;
    private Warehouse warehouse;
    private Cart cart;

    public Fulfillment(Warehouse warehouse, Supplier<Cart> cartSupplier) {
        this.warehouse = warehouse;
        this.cartSupplier = cartSupplier;
    }

    public void order(Product product, int quantity) {
        if (cart == null) cart = cartSupplier.get();
        if (warehouse.canFulfill(quantity, product)) {
             cart.add(quantity, product);
        }
    }

    public Cart getCart() {
        return cart;
    }
}
