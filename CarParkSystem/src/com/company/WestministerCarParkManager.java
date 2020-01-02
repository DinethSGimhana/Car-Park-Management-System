package com.company;


import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


import static com.company.Main.main;

public class WestministerCarParkManager implements CarParkManager{
    int choice;
    String vehicleID;
    private int no_of_Vehicles_onPark=0;
    private int remaining_slots;

    String entryDateTime,departrueDateTime;



    public int No_of_Vehicles_onPark(LinkedList<String> vehicle_IDList_onPark) {
        no_of_Vehicles_onPark =vehicle_IDList_onPark.size();
        return no_of_Vehicles_onPark;
    }

    public int Remaining_slots(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark) {
        remaining_slots =20-No_of_Vehicles_onPark(vehicle_IDList_onPark);
        return  remaining_slots;
    }

    public boolean is_Park_full(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark){
        if(No_of_Vehicles_onPark(vehicle_IDList_onPark)==20){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void add_New_Vehicle(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark) throws ParseException {
        if(is_Park_full(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark)){
            System.out.println("          !!!  PARK IS FULL  !!!");
        }
        else {
            System.out.println("    +----------------------------------------------------+");
            System.out.println("    |          Press 1 to Add a Car                      |");
            System.out.println("    |          Press 2 to Add a Van                      |");
            System.out.println("    |          Press 3 to Add a MotorBike                |");
            System.out.println("    |          Press 4 to Back to Main Menu              |");
            System.out.println("    |          Press 5 to Exit                           |");
            System.out.println("    +----------------------------------------------------+");
            System.out.print("\n        Enter the Choice:");
            choice=input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    Car car=new Car();
                    car.add_Car_Details();
                    carList_onPark.addFirst(car);
                    vehicle_IDList_onPark.addFirst(car.getVehicle_ID_plate());
                    no_of_Vehicles_onPark=No_of_Vehicles_onPark(vehicle_IDList_onPark);
                    break;
                case 2:
                    Van van = new Van();
                    if(Remaining_slots(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark)==1){
                        System.out.println("        !!! YOU CAN'T PARK A VAN !!!");
                    }
                    else {
                        van.add_Van_Details();
                        vanList_onPark.addFirst(van);
                        vehicle_IDList_onPark.addFirst(van.getVehicle_ID_plate());

                    }
                    no_of_Vehicles_onPark=No_of_Vehicles_onPark(vehicle_IDList_onPark);
                    break;
                case 3:
                    MotorBike motorBike=new MotorBike();
                    motorBike.add_MotorBike_details();
                    motorBikeList_onPark.addFirst(motorBike);
                    vehicle_IDList_onPark.addFirst(motorBike.getVehicle_ID_plate());
                    no_of_Vehicles_onPark=No_of_Vehicles_onPark(vehicle_IDList_onPark);
                    break;
                case 4:
                    main(null);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\n                                !!!!Invalid Choice!!!!\n\n");
                    add_New_Vehicle(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);
            }
            remaining_slots=Remaining_slots(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);
            System.out.println("        Remaining Free Parking Slots:"+ remaining_slots);
        }




    }

    @Override
    public void remove_a_Vehicle(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark) throws ParseException {
        System.out.println("    +----------------------------------------------------+");
        System.out.println("    |          Press 1 to Remove a Car                   |");
        System.out.println("    |          Press 2 to Remove a Van                   |");
        System.out.println("    |          Press 3 to Remove a MotorBike             |");
        System.out.println("    |          Press 4 to Back to Main Menu              |");
        System.out.println("    |          Press 5 to Exit                           |");
        System.out.println("    +----------------------------------------------------+");
        System.out.print("\n        Enter the Choice:");
        choice=input.nextInt();
        input.nextLine();
        if(choice==1||choice==2||choice==3){
        System.out.print("\n        Enter the Vehicle ID:");
        vehicleID=input.nextLine();
        System.out.print("\n        Enter the Departue Date & Time (dd/mm/yyyy HH:mm) :");
        departrueDateTime=input.nextLine();
        DateTime dateTime=new DateTime();

            Iterator<String> vID=vehicle_IDList_onPark.iterator();
            while (vID.hasNext()){
                String ID;
                ID = vID.next();
                for(Car car:carList_onPark){
                    if(ID.equals(car.getVehicle_ID_plate())){
                        entryDateTime=car.getEntry_DateTime();
                    }

                }
                for(Van van:vanList_onPark){
                    if(ID.equals(van.getVehicle_ID_plate())){
                        entryDateTime=van.getEntry_DateTime();
                    }
                }
                for(MotorBike motorBike:motorBikeList_onPark){
                    if(ID.equals(motorBike.getVehicle_ID_plate())){
                        entryDateTime=motorBike.getEntry_DateTime();
                    }
                }
            }
            dateTime.calculate_timeDuration(vehicleID,vehicle_IDList_onPark,entryDateTime,departrueDateTime);
            vehicle_IDList_onPark.remove(vehicle_IDList_onPark.indexOf(vehicleID));
            remaining_slots=Remaining_slots(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);
            System.out.println("        Remaining Free Parking Slots:"+ remaining_slots);
        }
        else if(choice==4){
            main(null);
        }
        else if(choice==5){
            return;
        }
        else{
            System.out.println("\n                                !!!!Invalid Choice!!!!\n\n");
            remove_a_Vehicle(vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);
        }
    }

    @Override
    public void show_All_Parked_Vehicles(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark) {
        if(remaining_slots==20){
            System.out.println("        !!!Currently Park is Empty!!!");
        }
        else{
            Iterator<String> vID=vehicle_IDList_onPark.iterator();
            while (vID.hasNext()){
                String ID;
                ID = vID.next();
                for(Car car:carList_onPark){
                    if(ID.equals(car.getVehicle_ID_plate())){
                        System.out.println(car.getVehicle_ID_plate()+"       "+car.getEntry_DateTime()+"       Car");
                    }

                }
                for(Van van:vanList_onPark){
                    if(ID.equals(van.getVehicle_ID_plate())){
                        System.out.println(van.getVehicle_ID_plate()+"       "+van.getEntry_DateTime()+"       Van");
                    }
                }
                for(MotorBike motorBike:motorBikeList_onPark){
                    if(ID.equals(motorBike.getVehicle_ID_plate())){
                        System.out.println(motorBike.getVehicle_ID_plate()+"       "+motorBike.getEntry_DateTime()+"       MotorBike");
                    }
                }
            }
        }
    }

    @Override
    public void display_Current_Statistics(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark) throws ParseException {
        String current_DateTime;
        System.out.print("        Enter the Date and Time right now (dd/mm/yyyy HH:mm) :");
        current_DateTime=input.nextLine();
        System.out.println("        Vehicle Percentages According to Vehicle Type:");
        double cars=0,vans=0,motorbikes=0;
        double car_percentage,van_percentage,motorbike_percentage;
        if(remaining_slots==20){
            System.out.println("        !!!Currently Park is Empty!!!");
        }
        else{
            Iterator<String> vID=vehicle_IDList_onPark.iterator();
            while (vID.hasNext()) {
                String ID;
                ID = vID.next();
                for (Car car : carList_onPark) {
                    if (ID.equals(car.getVehicle_ID_plate())) {
                        cars++;
                    }

                }
                for (Van van : vanList_onPark) {
                    if (ID.equals(van.getVehicle_ID_plate())) {
                        vans++;
                    }
                }
                for (MotorBike motorBike : motorBikeList_onPark) {
                    if (ID.equals(motorBike.getVehicle_ID_plate())) {
                        motorbikes++;
                    }
                }
            }
            car_percentage=(cars/vehicle_IDList_onPark.size())*100;
            van_percentage=(vans/vehicle_IDList_onPark.size())*100;
            motorbike_percentage=(motorbikes/vehicle_IDList_onPark.size())*100;
            System.out.println("        Cars            "+(double) Math.round(car_percentage * 100) / 100+"%");
            System.out.println("        Vans            "+(double) Math.round(van_percentage * 100) / 100+"%");
            System.out.println("        Motor Bike      "+(double) Math.round(motorbike_percentage* 100) / 100+"%");
        }
        System.out.println("\n        Last Parked Vehicle");
        String last_VID=vehicle_IDList_onPark.getFirst();
        for(Car car:carList_onPark){
            if(last_VID.equals(car.getVehicle_ID_plate())){
                System.out.println("        "+car.getVehicle_ID_plate()+"       "+car.getEntry_DateTime()+"       Car");
            }

        }
        for(Van van:vanList_onPark){
            if(last_VID.equals(van.getVehicle_ID_plate())){
                System.out.println("        "+van.getVehicle_ID_plate()+"       "+van.getEntry_DateTime()+"       Van");
            }
        }
        for(MotorBike motorBike:motorBikeList_onPark){
            if(last_VID.equals(motorBike.getVehicle_ID_plate())){
                System.out.println("        "+motorBike.getVehicle_ID_plate()+"       "+motorBike.getEntry_DateTime()+"       MotorBike");
            }
        }
        /*System.out.println("\n        Vehicle that Parked for the Longest Time:");
         DateTime dateTime=new DateTime();
        dateTime.longestTime_Vehicle(current_DateTime,vehicle_IDList_onPark,carList_onPark,vanList_onPark,motorBikeList_onPark);*/



    }

    @Override
    public void show_VehicleList_on_SpecificDate(LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark) {
        String specific_date;
        int count=0;
        System.out.print("        Enter the date to display Parked Vehicles (dd/mm/yyyy):");
        specific_date= input.nextLine();
            for(Car car:carList_onPark){
                if(specific_date.equals(car.getEntry_DateTime().substring(0,10))){
                    entryDateTime=car.getEntry_DateTime();
                    System.out.println("        "+car.getVehicle_ID_plate()+"              Car         "+car.getEntry_DateTime());
                    count++;
                }

            }
            for(Van van:vanList_onPark){
                if(specific_date.equals(van.getEntry_DateTime().substring(0,10))){
                    entryDateTime=van.getEntry_DateTime();
                    System.out.println("        "+van.getVehicle_ID_plate()+"              Van         "+van.getEntry_DateTime());
                    count++;
                }
            }
            for(MotorBike motorBike:motorBikeList_onPark){
                if(specific_date.equals(motorBike.getEntry_DateTime().substring(0,10))){
                    System.out.println("        "+motorBike.getVehicle_ID_plate()+"              Motor Bike         "+motorBike.getEntry_DateTime());
                    count++;
                }
            }
            if(count==0){
                System.out.println("        No Vehicles Parked on that day");
            }
            else if(count==1){
                System.out.println("        ***"+count+" Vehicle Parked on "+specific_date);
            }
            else{
                System.out.println("        ***"+count+" Vehicles Parked on "+specific_date);
            }







    }

    @Override
    public void display_Parking_Charges(String vehicleID,LinkedList<String> vehicle_IDList_onPark,long timeDuration_Hours,long timeDuration_Days) {
        long parkingCharge=0;
        System.out.println(timeDuration_Days+"        "+timeDuration_Hours);
        if(timeDuration_Days<=0 && timeDuration_Hours<=3){
            parkingCharge=3*timeDuration_Hours;
        }
        else if(timeDuration_Days<=0 && (timeDuration_Hours>3 &&timeDuration_Hours<24) ){
            parkingCharge=9+(1*timeDuration_Hours-3);
        }
        else{
            parkingCharge=(30*timeDuration_Days)+(1*timeDuration_Hours);
        }
        System.out.println("        Vehicle ID:"+vehicleID+"      Parking Charge:"+parkingCharge);
    }

}
