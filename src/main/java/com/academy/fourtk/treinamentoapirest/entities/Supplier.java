package com.academy.fourtk.treinamentoapirest.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonProperty("date_of_creation")
    private LocalDateTime dateOfCreation;

    @JsonProperty("date_of_the_last_update")
    private LocalDateTime dateOfTheLastUpdate;
}
