package com.company;

import java.util.Scanner;

public class Car extends Vehicle {
    private int no_of_doors;
    private String color;

    public void setNo_of_doors(int no_of_doors) {
        this.no_of_doors = no_of_doors;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNo_of_doors() {
        return no_of_doors;
    }

    public String getColor() {
        return color;
    }

    public void add_Car_Details(){
        Scanner input=new Scanner(System.in);
        System.out.print("        Enter the ID Plate:");
        setVehicle_ID_plate(input.nextLine());
        System.out.print("        Enter the Brand of the Vehicle:");
        setBrand_of_vehicle(input.nextLine());
        System.out.print("        Enter the Entry Date & Time (dd/mm/yyyy HH:mm) :");
        setEntry_DateTime(input.nextLine());
        System.out.print("        Enter the Color:");
        setColor(input.nextLine());
        System.out.print("        Enter the No of doors:");
        setNo_of_doors(input.nextInt());
    }
}
