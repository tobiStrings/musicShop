package com.example.musicalinstrumentstore.models.repositories;

import com.example.musicalinstrumentstore.models.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
