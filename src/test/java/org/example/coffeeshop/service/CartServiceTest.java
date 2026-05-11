package org.example.coffeeshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.example.coffeeshop.model.Product;
import org.junit.jupiter.api.Test;

class CartServiceTest {

    private final CartService cartService = new CartService();

    @Test
    void shouldAggregateDuplicateProducts() {
        Product latte = new Product(1L, "Латте", "Молочный кофе", BigDecimal.valueOf(240), "Кофе");

        cartService.addProduct(latte);
        cartService.addProduct(latte);

        assertEquals(1, cartService.getItems().size());
        assertEquals(2, cartService.getItemCount());
        assertEquals(BigDecimal.valueOf(480), cartService.getTotal());
    }
}
