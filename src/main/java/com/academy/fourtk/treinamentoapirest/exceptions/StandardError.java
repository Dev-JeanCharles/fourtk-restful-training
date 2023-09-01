package com.academy.fourtk.treinamentoapirest.exceptions;

import lombok.Data;

import java.time.Instant;

@Data
public class StandardError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
    private String message;
}
