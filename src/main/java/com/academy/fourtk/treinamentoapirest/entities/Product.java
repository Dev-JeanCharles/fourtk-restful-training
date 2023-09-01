package com.academy.fourtk.treinamentoapirest.entities;

import com.academy.fourtk.treinamentoapirest.dtos.requests.ProductRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonProperty("quantity_in_stock")
    private Integer quantityInStock;

    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @JsonProperty("date_of_creation")
    private LocalDateTime dateOfCreation = LocalDateTime.now();

    @JsonProperty("date_of_the_last_update")
    private LocalDateTime dateOfTheLastUpdate = LocalDateTime.now();

    public static Product convertProduct(ProductRequest request, Supplier supplier) {
        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        product.setSupplier(supplier);
        product.setUnitPrice(request.getUnitPrice());
        product.setQuantityInStock(request.getQuantityInStock());

        return product;
    }
}
