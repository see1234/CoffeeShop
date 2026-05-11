package org.example.coffeeshop.model;

import java.math.BigDecimal;

public class Product {

    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final String category;

    public Product(Long id, String name, String description, BigDecimal price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
