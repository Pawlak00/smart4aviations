package com.smart4aviation.smart4aviation.repositories;

import com.smart4aviation.smart4aviation.models.Flight;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String> {
    Flight findBy_id(ObjectId _id);
    List<Flight> findAll();
    Flight findByflightNumberAndDepartureDate(int flightNumber,String date);
    List<Flight> findByDepartureAirportIATACodeAndDepartureDate(String code,String date);
    List<Flight> findByArrivalAirportIATACodeAndDepartureDate(String code,String date);
}
