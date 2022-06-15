package com.example.musicalinstrumentstore.models.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Book {
    @Id
    private String id;
    private String name;
    private String imageId;
    private Long quantityAvailable;
    private String shortDescription;
    private Types.BookType bookType;
    private BigDecimal price;
}
