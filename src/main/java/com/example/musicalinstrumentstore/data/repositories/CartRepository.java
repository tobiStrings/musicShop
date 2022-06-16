package com.example.musicalinstrumentstore.data.repositories;

import com.example.musicalinstrumentstore.data.models.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {
}
