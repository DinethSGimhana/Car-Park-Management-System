package com.company;


import java.util.Scanner;

public abstract class Vehicle {
    private String vehicle_ID_plate;
    private String brand_of_vehicle;
    private String entry_DateTime;

    Scanner input=new Scanner(System.in);


    public void setVehicle_ID_plate(String vehicle_ID_plate) {
        this.vehicle_ID_plate = vehicle_ID_plate;
    }

    public void setBrand_of_vehicle(String brand_of_vehicle) {
        this.brand_of_vehicle = brand_of_vehicle;
    }

    public void setEntry_DateTime(String entry_DateTime) {
        this.entry_DateTime = entry_DateTime;
    }

    public String getVehicle_ID_plate() {
        return vehicle_ID_plate;
    }

    public String getBrand_of_vehicle() {
        return brand_of_vehicle;
    }

    public String getEntry_DateTime() {
        return entry_DateTime;
    }


}
