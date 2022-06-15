package com.example.musicalinstrumentstore.models.repositories;

import com.example.musicalinstrumentstore.models.data.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {
}
