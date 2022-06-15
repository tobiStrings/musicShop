package com.example.musicalinstrumentstore.models.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Cart {
    @Id
    private String id;
    @DBRef
    private User user;
    private List<Instrument> instruments;
    private List<Book>books;
    private Long numberOfItemsInCart;
}
