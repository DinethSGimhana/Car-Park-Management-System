package com.company;

import java.util.Scanner;

public class MotorBike extends Vehicle {
    private int engine_size;

    public void setEngine_size(int engine_size) {
        this.engine_size = engine_size;
    }

    public int getEngine_size() {
        return engine_size;
    }

    public void add_MotorBike_details(){
        Scanner input=new Scanner(System.in);
        System.out.print("        Enter the ID Plate:");
        setVehicle_ID_plate(input.nextLine());
        System.out.print("        Enter the Brand of the Vehicle:");
        setBrand_of_vehicle(input.nextLine());
        System.out.print("        Enter the Entry Date & Time (dd/mm/yyyy HH:mm):");
        setEntry_DateTime(input.nextLine());
        System.out.print("        Enter the Engine Capacity (cc):");
        setEngine_size(input.nextInt());

    }
}
