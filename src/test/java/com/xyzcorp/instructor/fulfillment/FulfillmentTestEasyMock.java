package com.xyzcorp.instructor.fulfillment;

import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;

public class FulfillmentTestEasyMock {
    @Test
    void testFulfillmentWithZeroInventory() {
        Warehouse warehouse = mock(Warehouse.class);
        Cart cart = mock(CartMap.class);
        Product skyGalaxyEarbuds = new Product("Sky Galaxy Earbuds");
        expect(warehouse.canFulfill(3, skyGalaxyEarbuds)).andReturn(false);
        Fulfillment fulfillment = new Fulfillment(warehouse, () -> cart);
        replay(warehouse, cart);
        fulfillment.order(skyGalaxyEarbuds, 3);
        verify(warehouse, cart);
    }

    @Test
    void testFulfillmentWithThreeInventory() {
        Warehouse warehouse = mock(Warehouse.class);
        Cart cart = mock(CartMap.class);
        Product skyGalaxyEarbuds = new Product("Sky Galaxy Earbuds");
        expect(warehouse.canFulfill(3, skyGalaxyEarbuds)).andReturn(true);
        cart.add(3, skyGalaxyEarbuds);
        Fulfillment fulfillment = new Fulfillment(warehouse, () -> cart);
        replay(warehouse, cart);
        fulfillment.order(skyGalaxyEarbuds, 3);
        verify(warehouse, cart);
    }
}
