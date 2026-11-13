package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        //Create the dealership with an empty inventory
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public ArrayList<Vehicle>getAllVehicles() {
        return this.inventory;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

    public ArrayList<Vehicle>getAllVehiclesByPrice(BigDecimal min, BigDecimal max){
        //loop over inventory and return a list of vehicles that match the price range

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        //return the list
        return null;
    }

    public ArrayList<Vehicle>getVehiclesByMakeAndModel(String make, String model){
        //loop over inventory and return a list of vehicles that match the make/model

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        //return the list
        //will not return null until finished
        return null;
    }

    public ArrayList<Vehicle>getVehiclesByYear(int min , int max){
        //loop over inventory and return a list of vehicles that match the year

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        //return the list
        //will not return null until finished
        return null;

    }

    public ArrayList<Vehicle>getVehiclesByColor(String color){
        //loop over inventory and return a list of vehicles that match the color

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        //return the list
        //will not return null until finished
        return null;
    }

    public ArrayList<Vehicle>getVehiclesByMileage(BigDecimal min,  BigDecimal max){
        //loop over inventory and return a list of vehicles that match the mileage

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        //return the list
        //will not return null until finished
        return null;
    }

    public ArrayList<Vehicle>getVehiclesByType(Vehicle type){
        //loop over inventory and return a list of vehicles that match the type

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        //return the list
        //will not return null until finished
        return null;
    }







}
