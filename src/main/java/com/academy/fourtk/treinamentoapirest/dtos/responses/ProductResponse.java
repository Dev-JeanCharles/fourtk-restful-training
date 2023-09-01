package com.academy.fourtk.treinamentoapirest.dtos.responses;

import com.academy.fourtk.treinamentoapirest.entities.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private Integer quantityInStock;
    private BigDecimal unitPrice;
    private String supplierName;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfTheLastUpdate;

    public static ProductResponse convertResponse(Product savedProduct) {
        ProductResponse response = new ProductResponse();
        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setQuantityInStock(savedProduct.getQuantityInStock());
        response.setUnitPrice(savedProduct.getUnitPrice());
        response.setSupplierName(savedProduct.getSupplier().getName());
        response.setDateOfCreation(savedProduct.getDateOfCreation());
        response.setDateOfTheLastUpdate(savedProduct.getDateOfTheLastUpdate());

        return response;
    }
}
