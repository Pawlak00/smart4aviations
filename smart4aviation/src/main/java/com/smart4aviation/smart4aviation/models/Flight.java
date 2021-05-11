package com.smart4aviation.smart4aviation.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Flight {
    @Id
    private ObjectId _id;
    private int flightId;
    private int flightNumber;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private String departureDate;
    public Flight(int flightNumber,int flightId,String departureAirportIATACode,String arrivalAirportIATACode,String departureDate){
        this.setFlightNumber(flightNumber);
        this.setFlightId(flightId);
        this.setDepartureAirportIATACode(departureAirportIATACode);
        this.setArrivalAirportIATACode(arrivalAirportIATACode);
        this.setDepartureDate(departureDate);
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public void setDepartureAirportIATACode(String departureAirportIATACode) {
        this.departureAirportIATACode = departureAirportIATACode;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
        this.arrivalAirportIATACode = arrivalAirportIATACode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
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
}
