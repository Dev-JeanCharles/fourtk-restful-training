package com.academy.fourtk.treinamentoapirest.util;

import com.academy.fourtk.treinamentoapirest.dtos.requests.ProductRequest;

public class ProductRequestBuild {

    public static ProductRequest saveProduct() {
        return ProductRequest.builder()
                .id(ProductResponseBuild.saveProduct().getId())
                .name(ProductResponseBuild.saveProduct().getName())
                .supplierId(SupplierCreate.saveSupplier().getId())
                .unitPrice(ProductResponseBuild.saveProduct().getUnitPrice())
                .quantityInStock(ProductResponseBuild.saveProduct().getQuantityInStock())
                .build();
    }

}
