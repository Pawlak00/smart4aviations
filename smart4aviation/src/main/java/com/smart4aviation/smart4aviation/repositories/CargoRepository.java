package com.smart4aviation.smart4aviation.repositories;

import com.smart4aviation.smart4aviation.models.Cargo;
import com.smart4aviation.smart4aviation.models.Flight;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CargoRepository extends MongoRepository<Cargo, String> {
    Cargo findBy_id(ObjectId _id);
    List<Cargo> findAll();
    List<Cargo> findBy(int flightNumber);
    Cargo findByFlightId(int flightId);
    List<Cargo> findByFlightIdIn(List<Integer>flights);
}
