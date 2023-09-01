package com.academy.fourtk.treinamentoapirest.dtos.requests;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class ProductRequest {
    private Long id;

    @NotBlank(message = "Required field")
    @NotNull(message = "Field not null")
    @Size(min = 3, max = 20, message = "Field requires 3 to 20 characters")
    private String name;

    @PositiveOrZero(message = "Field requires a positive value and greater than zero")
    @NotNull(message = "Field not null")
    private Integer quantityInStock;

    @PositiveOrZero(message = "Field requires a positive value and greater than zero")
    @NotNull(message = "Field not null")
    @DecimalMin(value = "0.0", message = "Field requires a decimal value: (0.0)")
    @Digits(integer = 4, fraction = 2, message = "Field requires for maximum 4 characters")
    private BigDecimal unitPrice;

    @NotNull(message = "Field not null")
    private Long supplierId;
}
