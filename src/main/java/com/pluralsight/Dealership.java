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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <= 0){
                vehicles.add(vehicle);
            }
        }

        //return the list
        return vehicles;
    }

    public ArrayList<Vehicle>getVehiclesByMakeAndModel(String make, String model){
        //loop over inventory and return a list of vehicles that match the make/model

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : this.inventory){
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)){
                vehicles.add(vehicle);
            }
        }

        //return the list
        //will not return null until finished
        return vehicles;
    }

    public ArrayList<Vehicle>getVehiclesByYear(int min , int max){
        //loop over inventory and return a list of vehicles that match the year

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : this.inventory){
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                vehicles.add(vehicle);
            }
        }

        //return the list
        //will not return null until finished
        return vehicles;

    }

    public ArrayList<Vehicle>getVehiclesByColor(String color){
        //loop over inventory and return a list of vehicles that match the color

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : this.inventory){
            if (vehicle.getColor().equals(color)){
                vehicles.add(vehicle);
            }
        }

        //return the list
        //will not return null until finished
        return vehicles;
    }

    public ArrayList<Vehicle>getVehiclesByMileage(BigDecimal min,  BigDecimal max){
        //loop over inventory and return a list of vehicles that match the mileage

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : this.inventory){
           //Add .valueOf() to get the value of the odometer
            BigDecimal mileage = BigDecimal.valueOf(vehicle.getOdometer());

            if (mileage.compareTo(min) >= 0 && mileage.compareTo(max) <= 0){
                vehicles.add(vehicle);
            }
        }

        //return the list
        //will not return null until finished
        return vehicles;
    }

    public ArrayList<Vehicle>getVehiclesByType(String type){
        //loop over inventory and return a list of vehicles that match the type

        //Start a new list for the filtered cars
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        //add for loop
        for (Vehicle vehicle : this.inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(type)){
                vehicles.add(vehicle);
            }
        }

        //return the list
        //will not return null until finished
        return vehicles;
    }







}
