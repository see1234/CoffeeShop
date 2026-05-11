package org.example.coffeeshop.web;

import org.example.coffeeshop.service.CartService;
import org.example.coffeeshop.service.ProductCatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    private final ProductCatalogService productCatalogService;
    private final CartService cartService;

    public StoreController(ProductCatalogService productCatalogService, CartService cartService) {
        this.productCatalogService = productCatalogService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productCatalogService.findAll());
        model.addAttribute("cartCount", cartService.getItemCount());
        return "index";
    }
}
