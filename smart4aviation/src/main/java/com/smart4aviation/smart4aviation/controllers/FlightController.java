package com.smart4aviation.smart4aviation.controllers;

import com.smart4aviation.smart4aviation.models.Baggage;
import com.smart4aviation.smart4aviation.models.Cargo;
import com.smart4aviation.smart4aviation.models.Flight;
import com.smart4aviation.smart4aviation.repositories.CargoRepository;
import com.smart4aviation.smart4aviation.repositories.FlightRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private CargoRepository cargoRepository;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Flight> getAllFlights(){
        System.out.println("getting all flights");
        return  flightRepository.findAll();
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public Flight getCargoById(@PathVariable("id")ObjectId id){
        return flightRepository.findBy_id(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public HashMap<String, Double> getFlightId(@RequestParam(value="flightNumber")int flightNumber, @RequestParam(value="date")String date){
        Flight flight=flightRepository.findByflightNumberAndDepartureDate(flightNumber,date);
        Cargo flightParams=cargoRepository.findByFlightId(flight.getFlightId());
        double cargoSum=0.0;
        for(Baggage b:flightParams.getCargo()){
            cargoSum+=b.getWeight();
        }
        double baggageSum=0.0;
        for(Baggage b:flightParams.getBaggage()){
            baggageSum+=b.getWeight();
        }
        HashMap<String, Double> map = new HashMap<>();
        map.put("cargoSum", cargoSum);
        map.put("baggageSum", baggageSum);
        map.put("total", cargoSum+baggageSum);
        return map;
    }

}
