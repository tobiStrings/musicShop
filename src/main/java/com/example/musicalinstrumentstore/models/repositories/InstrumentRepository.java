package com.example.musicalinstrumentstore.models.repositories;

import com.example.musicalinstrumentstore.models.data.Instrument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends MongoRepository<Instrument,String> {

}
