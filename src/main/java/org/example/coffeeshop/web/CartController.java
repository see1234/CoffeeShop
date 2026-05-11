package org.example.coffeeshop.web;

import org.example.coffeeshop.service.CartService;
import org.example.coffeeshop.service.ProductCatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    private final CartService cartService;
    private final ProductCatalogService productCatalogService;

    public CartController(CartService cartService, ProductCatalogService productCatalogService) {
        this.cartService = cartService;
        this.productCatalogService = productCatalogService;
    }

    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable Long productId) {
        var product = productCatalogService.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Товар не найден"));
        cartService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("items", cartService.getItems());
        model.addAttribute("total", cartService.getTotal());
        return "cart";
    }

    @PostMapping("/cart/checkout")
    public String checkout() {
        cartService.clear();
        return "redirect:/cart?success";
    }
}
