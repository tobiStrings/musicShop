package com.example.musicalinstrumentstore.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Instrument {
    @Id
    private String id;
    private String name;
    private Long quantityAvailable;
    private String shortDescription;
    private String imageId;
    private BigDecimal price;
    private Types.InstrumentCategory instrumentCategory;
}
