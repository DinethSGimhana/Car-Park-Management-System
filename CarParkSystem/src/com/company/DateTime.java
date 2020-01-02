package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;



public class DateTime {
    static long logest_Time;
    static String longest_timeVehicleID;
    long timeDuration;
    long timeDuration_Hours;
    long timeDuration_Days;
    public void calculate_timeDuration(String vehicle_ID,LinkedList<String> vehicle_IDList_onPark, String entry_DateTime, String departure_DateTime){
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date entry=null;
        Date departure=null;

        try{
            entry=format.parse(entry_DateTime);
            departure=format.parse(departure_DateTime);

            timeDuration=departure.getTime()-entry.getTime();

            timeDuration_Hours=timeDuration/(60*60*1000)%24;
            timeDuration_Days=timeDuration/(24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        WestministerCarParkManager westministerCarParkManager=new WestministerCarParkManager();
        westministerCarParkManager.display_Parking_Charges(vehicle_ID,vehicle_IDList_onPark,timeDuration_Hours,timeDuration_Days);

    }
    /*public String longestTime_Vehicle(String current_DateTime,LinkedList<String> vehicle_IDList_onPark,LinkedList <Car> carList_onPark,LinkedList <Van> vanList_onPark,LinkedList <MotorBike> motorBikeList_onPark) throws ParseException {
        String entryDateTime;
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

            for(Car car:carList_onPark){
                if(longest_Time_Vehicle_ID.equals(car.getVehicle_ID_plate())){
                    System.out.println("        "+car.getVehicle_ID_plate()+"       "+car.getEntry_DateTime()+"       Car");
                }

            }
            for(Van van:vanList_onPark){
                if(longest_Time_Vehicle_ID.equals(van.getVehicle_ID_plate())){
                    System.out.println("        "+van.getVehicle_ID_plate()+"       "+van.getEntry_DateTime()+"       Van");
                }
            }
            for(MotorBike motorBike:motorBikeList_onPark){
                if(longest_Time_Vehicle_ID.equals(motorBike.getVehicle_ID_plate())){
                    System.out.println("        "+motorBike.getVehicle_ID_plate()+"       "+motorBike.getEntry_DateTime()+"       MotorBike");
                }
            }

        }
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date entry=null;
        Date departure=null;


            entry=format.parse(entryDateTime);
            departure=format.parse(current_DateTime);

            timeDuration=departure.getTime()-entry.getTime();
            if(logest_Time<timeDuration){
                logest_Time=timeDuration;
                longest_timeVehicleID=vehicleID;

            }
            return longest_timeVehicleID;


    }*/


}
