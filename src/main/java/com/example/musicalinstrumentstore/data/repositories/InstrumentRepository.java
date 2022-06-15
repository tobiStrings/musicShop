package com.example.musicalinstrumentstore.data.repositories;

import com.example.musicalinstrumentstore.data.models.Instrument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends MongoRepository<Instrument,String> {

}
