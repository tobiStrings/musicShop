package com.example.musicalinstrumentstore.models.repositories;

import com.example.musicalinstrumentstore.models.data.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {

}
