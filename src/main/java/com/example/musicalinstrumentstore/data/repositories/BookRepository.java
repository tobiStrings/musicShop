package com.example.musicalinstrumentstore.data.repositories;

import com.example.musicalinstrumentstore.data.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {

}
