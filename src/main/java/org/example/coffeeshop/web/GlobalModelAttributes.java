package org.example.coffeeshop.web;

import org.example.coffeeshop.service.CartService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributes {

    private final CartService cartService;

    public GlobalModelAttributes(CartService cartService) {
        this.cartService = cartService;
    }

    @ModelAttribute("globalCartCount")
    public int globalCartCount() {
        return cartService.getItemCount();
    }
}
