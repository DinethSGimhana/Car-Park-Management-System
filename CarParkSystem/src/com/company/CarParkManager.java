package com.company;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.Scanner;

public interface CarParkManager {
    Scanner input=new Scanner(System.in);
    public void add_New_Vehicle(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark) throws ParseException;
    void remove_a_Vehicle(LinkedList<String> vehicle_IDList_onPark, LinkedList <Car> carList_onPark, LinkedList <Van> vanList_onPark, LinkedList <MotorBike> motorBikeList_onPark) throws ParseException;
    void show_All_Parked_Vehicles(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark);
    void display_Current_Statistics(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark) throws ParseException;
    void show_VehicleList_on_SpecificDate(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark);
    void display_Parking_Charges(String vehicleID,LinkedList<String> vehicle_IDList_onPark,long timeDuration_Hours,long timeDuration_Days);
}
