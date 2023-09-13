package com.academy.fourtk.treinamentoapirest.util;

import com.academy.fourtk.treinamentoapirest.entities.Product;

import java.time.LocalDateTime;

public class ProductCreate {

    public static Product saveProduct() {
        return Product.builder()
                .id(ProductRequestBuild.saveProduct().getId())
                .name(ProductRequestBuild.saveProduct().getName())
                .supplier(SupplierCreate.saveSupplier())
                .unitPrice(ProductRequestBuild.saveProduct().getUnitPrice())
                .quantityInStock(ProductRequestBuild.saveProduct().getQuantityInStock())
                .dateOfCreation(LocalDateTime.now())
                .dateOfTheLastUpdate(LocalDateTime.now())
                .build();
    }
}
