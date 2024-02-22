package com.coherentsolution.section04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void givenEmptyCart_whenAddRealItem_thenTotalPriceIncreases() {
        // Given: an empty cart
        assertEquals(0, cart.getTotalPrice(), "Cart total price should initially be 0");

        // When: a real item is added
        cart.addItem(new Cart.Item("Book", 9.99));

        // Then: total price increases
        assertEquals(9.99, cart.getTotalPrice(), "Cart total price should increase after adding an item");
    }
}
