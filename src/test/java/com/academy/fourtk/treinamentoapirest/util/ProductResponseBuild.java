package com.academy.fourtk.treinamentoapirest.util;

import com.academy.fourtk.treinamentoapirest.dtos.responses.ProductResponse;

import java.math.BigDecimal;

public class ProductResponseBuild {

    public static ProductResponse saveProduct() {
        return ProductResponse.builder()
                .id(1L)
                .name("Biscoito")
                .supplierName("Supermarket")
                .unitPrice(BigDecimal.valueOf(20.0))
                .quantityInStock(40)
                .build();
    }
}
