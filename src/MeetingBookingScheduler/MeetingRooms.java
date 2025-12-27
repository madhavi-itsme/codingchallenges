package MeetingBookingScheduler;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MeetingRooms {

    public String getName() {
        return name;
    }

    private String name;
    private int capacity;
    private List<Booking> bookings;
    private HashMap<String, List<Booking>> bookingsMap=new HashMap<>();


    public void addBooking(String name, List<Booking> booking) {
        if(bookingsMap.containsKey(name)){
            for(Booking b:booking) {
                List<Booking> localBooking = bookingsMap.get(name);
                localBooking.add(b);
                bookingsMap.put(name, localBooking);
            }
        } else {
            bookingsMap.put(name, booking);
        }
        this.bookings=bookingsMap.get(name);
    }

   public int getCapacity() {
        return capacity;
    }

    public  MeetingRooms(String name, int capacity,List<Booking> bookings) {
        this.name = name;
        this.capacity = capacity;
        addBooking(name,bookings);
    }

    public boolean isAvailable(int startTime, int endTime) {
        for(Booking booking: bookings){
            if(endTime > booking.getStarttime() && startTime < booking.getEndtime()){
                return false;
            }
        }
        return true;
    }

    public String bookRoom(int startTime, int endTime, int capacity) {

       if(isAvailable(startTime, endTime) && capacity <= this.capacity){
           bookings.add(new Booking(startTime, endTime));
           return "Room "+name  +"booked successfully from" + startTime +" to "+ endTime;
       }

       return "Booking failed: timeslot unavailable";
    }

    @Override
    public String toString() {
        return "Room " + name + " (Capacity: " + capacity + ")";
    }
}
