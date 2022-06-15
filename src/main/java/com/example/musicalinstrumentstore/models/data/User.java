package com.example.musicalinstrumentstore.models.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private String id;
    private String email;
    private String phoneNumber;
    private String password;
    private Types.Role userRole;
    private Cart userCart;
}
