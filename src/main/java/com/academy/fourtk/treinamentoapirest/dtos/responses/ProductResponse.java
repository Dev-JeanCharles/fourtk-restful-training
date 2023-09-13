package com.academy.fourtk.treinamentoapirest.dtos.responses;

import com.academy.fourtk.treinamentoapirest.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private Integer quantityInStock;
    private BigDecimal unitPrice;
    private String supplierName;
    public static ProductResponse convertResponse(Product savedProduct) {
        ProductResponse response = new ProductResponse();
        response.setId(savedProduct.getId());
        response.setName(savedProduct.getName());
        response.setQuantityInStock(savedProduct.getQuantityInStock());
        response.setUnitPrice(savedProduct.getUnitPrice());
        response.setSupplierName(savedProduct.getSupplier().getName());
        return response;
    }
}
