package parkinglot;

import java.util.*;

public class ParkingHandler {

    Map<String, Vehical> filledParking=new HashMap<>();
    Map<Entries, LinkedList<Integer>> availableParking=new HashMap<>();

    ParkingHandler(){
        availableParking.put(Entries.ENTRY1, new LinkedList<>(Arrays.asList(1,2,3,4,5,6)));
        availableParking.put(Entries.ENTRY2, new LinkedList<>(Arrays.asList(7,8,9,10,11,12)));
        availableParking.put(Entries.ENTRY3,new LinkedList<>(Arrays.asList(13,14,15,16,17,18)));
    }


    /* Based on the entry point appropriate vehical will be parked in the parking lot.*/
    public void parkVehical(String entry, Vehical vehical){
        if(entry.equalsIgnoreCase(Entries.ENTRY1.toString())){
            LinkedList<Integer> parkingAvailable=availableParking.get(Entries.ENTRY1);
             int available=parkingAvailable.removeFirst();
             availableParking.put(Entries.ENTRY1,parkingAvailable);
            filledParking.put(Entries.ENTRY1+","+available,vehical);

        } else if(entry.equalsIgnoreCase(Entries.ENTRY2.toString())){
            LinkedList<Integer> parkingAvailable=availableParking.get(Entries.ENTRY2);
            int available=parkingAvailable.removeFirst();
            parkingAvailable.removeFirst();
            availableParking.put(Entries.ENTRY2,parkingAvailable);
            filledParking.put(Entries.ENTRY2+","+available,vehical);

        } else if(entry.equalsIgnoreCase(Entries.ENTRY3.toString())){
            LinkedList<Integer> parkingAvailable=availableParking.get(Entries.ENTRY3);
            int available=parkingAvailable.removeFirst();
            parkingAvailable.removeFirst();
            availableParking.put(Entries.ENTRY3,parkingAvailable);
            filledParking.put(Entries.ENTRY3+","+available,vehical);
        }
    }

    public void emptyParking(String vehicalNumber){
        for(Map.Entry<String,Vehical> map:filledParking.entrySet()){
            String key=map.getKey();
            Vehical vehical=map.getValue();
            if(vehical.getLicensePlate().equalsIgnoreCase(vehicalNumber)){
                String[] temp=key.split(",");
                filledParking.remove(key);
                LinkedList<Integer> available=availableParking.get(temp[0]);
                available.addLast(Integer.valueOf(temp[1]));//add(Integer.valueOf(temp[1]));
                availableParking.put(Entries.valueOf(temp[0]),available);
            }

        }
    }

}


