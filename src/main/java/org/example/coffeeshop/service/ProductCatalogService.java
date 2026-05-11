package org.example.coffeeshop.service;

import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.example.coffeeshop.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogService {

    private final Map<Long, Product> products = new LinkedHashMap<>();

    @PostConstruct
    void init() {
        add(new Product(1L, "Капучино", "Эспрессо, молоко и плотная молочная пена", BigDecimal.valueOf(220), "Кофе"));
        add(new Product(2L, "Латте", "Мягкий кофе с большим количеством молока", BigDecimal.valueOf(240), "Кофе"));
        add(new Product(3L, "Флэт уайт", "Насыщенный двойной эспрессо с шелковистым молоком", BigDecimal.valueOf(260), "Кофе"));
        add(new Product(4L, "Воронка Эфиопия", "Фильтр-кофе с ягодной кислотностью", BigDecimal.valueOf(290), "Спешелти"));
        add(new Product(5L, "Чизкейк", "Классический десерт к кофе", BigDecimal.valueOf(210), "Десерты"));
        add(new Product(6L, "Круассан", "Сливочный круассан с хрустящей корочкой", BigDecimal.valueOf(180), "Выпечка"));
    }

    private void add(Product product) {
        products.put(product.getId(), product);
    }

    public List<Product> findAll() {
        return products.values().stream().toList();
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }
}
