package com.smart4aviation.smart4aviation.models;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;

import java.util.List;

public class Cargo {
    @Id
    private ObjectId _id;
    private int flightId;
    private List<Baggage> baggage;
    private List<Baggage> cargo;
    public Cargo(ObjectId _id,int flightId, List<Baggage> baggage,List<Baggage>cargo){
        this.set_id(_id);
        this.setFlightId(flightId);
        this.setBaggage(baggage);
        this.setCargo(cargo);
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Baggage> baggage) {
        this.baggage = baggage;
    }

    public List<Baggage> getCargo() {
        return cargo;
    }

    public void setCargo(List<Baggage> cargo) {
        this.cargo = cargo;
    }
}
