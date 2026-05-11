package org.example.coffeeshop.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.example.coffeeshop.model.CartItem;
import org.example.coffeeshop.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class CartService {

    private final Map<Long, CartItem> items = new LinkedHashMap<>();

    public void addProduct(Product product) {
        CartItem existing = items.get(product.getId());
        if (existing != null) {
            existing.increment();
            return;
        }

        items.put(product.getId(), new CartItem(product.getId(), product.getName(), product.getPrice(), 1));
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public BigDecimal getTotal() {
        return items.values().stream()
                .map(CartItem::getLineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getItemCount() {
        return items.values().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    public void clear() {
        items.clear();
    }
}
