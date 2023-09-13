package com.academy.fourtk.treinamentoapirest.util;

import com.academy.fourtk.treinamentoapirest.entities.Supplier;

import java.time.LocalDateTime;

public class SupplierResponseBuild {

    public static Supplier saveSupplier() {
        return Supplier.builder()
                .id(1L)
                .name("Supermarket")
                .dateOfCreation(LocalDateTime.now())
                .dateOfTheLastUpdate(LocalDateTime.now())
                .build();

    }

}
