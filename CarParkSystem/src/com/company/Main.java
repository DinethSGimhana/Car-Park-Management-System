package com.company;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    static LinkedList<String> vehicle_IDList_onPark=new LinkedList<String>();
    static LinkedList <Car> carList_onPark=new LinkedList<Car>();
    static LinkedList <Van> vanList_onPark=new LinkedList<Van>();
    static LinkedList <MotorBike> motorBikeList_onPark=new LinkedList<MotorBike>();


    public static void main(String[] args) throws ParseException {



        Scanner input=new Scanner(System.in);
        int choice;
        CarParkManager carParkManager=new WestministerCarParkManager();
        System.out.println("    +-------------------------------------------------------------------------------+");
        System.out.println("    |                   Welcome to Westminister Car Parking System                  |");
        System.out.println("    +-------------------------------------------------------------------------------+");
        System.out.println("    |          Press 1 to Add a Vehicle to the Park                                 |");
        System.out.println("    |          Press 2 to Remove a Vehicle from the Park                            |");
        System.out.println("    |          Press 3 to Display all the Vehicles Currently Parked                 |");
        System.out.println("    |          Press 4 to Display some Statistics                                   |");
        System.out.println("    |          Press 5 to Display all the Vehicles that Parked on Specific Date     |");
        System.out.println("    |          Press 6 to Exit                                                      |");
        System.out.println("    +-------------------------------------------------------------------------------+");
        System.out.print("\n        Enter the Choice:");
        choice=input.nextInt();
        switch (choice){
            case 1:
                carParkManager.add_New_Vehicle(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);
                main(args);
                break;
            case 2:
                carParkManager.remove_a_Vehicle(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);
                main(args);
                break;
            case 3:
                carParkManager.show_All_Parked_Vehicles(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);
                main(args);
                break;
            case 4:
                carParkManager.display_Current_Statistics(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);
                break;
            case 5:
                carParkManager.show_VehicleList_on_SpecificDate(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);
                break;
            case 6:
                return ;
            default:
                System.out.println("\n                                !!!!Invalid Choice!!!!\n\n");
                main(null);


        }
    }
}
