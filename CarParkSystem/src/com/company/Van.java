package com.company;

import java.util.Scanner;

public class Van extends Vehicle {
    private int cargo_Volume;

    public void setCargo_Volume(int cargo_Volume) {
        this.cargo_Volume = cargo_Volume;
    }

    public int getCargo_Volume() {
        return cargo_Volume;
    }

    public void add_Van_Details(){
        Scanner input=new Scanner(System.in);
        System.out.print("        Enter the ID Plate:");
        setVehicle_ID_plate(input.nextLine());
        System.out.print("        Enter the Brand of the Vehicle:");
        setBrand_of_vehicle(input.nextLine());
        System.out.print("        Enter the Entry Date & Time (dd/mm/yyyy HH:mm):");
        setEntry_DateTime(input.nextLine());
        System.out.print("        Enter the Cargo Volume(cubic feet):");
        setCargo_Volume(input.nextInt());
    }
}
