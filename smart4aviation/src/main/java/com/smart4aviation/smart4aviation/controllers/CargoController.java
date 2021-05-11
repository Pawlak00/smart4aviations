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
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private FlightRepository flightRepository;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Cargo> getAllCargos(){
        System.out.println("getting all cargos");
        return  cargoRepository.findAll();
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public Cargo getCargoById(@PathVariable("id")ObjectId id){
        return cargoRepository.findBy_id(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public HashMap<String,Integer> getAirportDetails(@RequestParam(value="IATA")String IATA, @RequestParam(value = "departDate")String date){
        List<Flight> Departs=flightRepository.findByDepartureAirportIATACodeAndDepartureDate(IATA,date);
        List<Flight> Arrivals=flightRepository.findByArrivalAirportIATACodeAndDepartureDate(IATA,date);
        List<Integer>arrivalsFlightId=new ArrayList<>();
        for(Flight f:Arrivals){
            arrivalsFlightId.add(f.getFlightId());
        }
        List<Cargo> piecesArriving=cargoRepository.findByFlightIdIn(arrivalsFlightId);
        List<Integer>departsFlightId=new ArrayList<>();
        for(Flight f:Departs){
            departsFlightId.add(f.getFlightId());
        }
        List<Cargo> piecesDeparting=cargoRepository.findByFlightIdIn(departsFlightId);
        Integer totalPiecesArriving=0;
        for(Cargo c:piecesArriving){
            for(Baggage b:c.getBaggage()) {
                totalPiecesArriving +=b.getPieces();
            }
        }
        Integer totalPiecesDeparting=0;
        for(Cargo c:piecesDeparting){
            for(Baggage b:c.getBaggage()) {
                totalPiecesDeparting +=b.getPieces();
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put("flightsDepart", Departs.size());
        map.put("flightsArrive", Arrivals.size());
        map.put("piecesDepart", totalPiecesDeparting);
        map.put("piecesArrive",totalPiecesArriving);
        return map;
    }
}
