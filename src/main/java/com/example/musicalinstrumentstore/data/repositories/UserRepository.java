package com.example.musicalinstrumentstore.data.repositories;

import com.example.musicalinstrumentstore.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findUserByEmail(String email);
}
