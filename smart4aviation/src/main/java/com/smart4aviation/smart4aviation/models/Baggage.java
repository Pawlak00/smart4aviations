package com.smart4aviation.smart4aviation.models;

import org.bson.types.ObjectId;

public class Baggage {
    private ObjectId id;
    private int weight;
    private String weightUnit;
    private int pieces;
    public Baggage(ObjectId id,int weight,String weightUnit,int pieces){
        this.id=id;
        this.weight=weight;
        this.weightUnit=weightUnit;
        this.pieces=pieces;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public double getWeight() {
//        return weight in kgs
        if(weightUnit.equals("lb")){
            return weight*0.453;
        }
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit.toString();
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
