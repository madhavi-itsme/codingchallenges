package MeetingBookingScheduler;



import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;


/*
* Background:
A company has multiple meeting rooms. Employees want to book these rooms for meetings.
Your task is to build a simple meeting room scheduler.

Requirements:
Implement a class-based system for managing meeting room bookings.
Each room has:
A unique name.
A capacity.
*
*
A booking has:
A meeting room.
A start time and end time.
A list of attendees.

Constraints:
A room cannot be double-booked during overlapping times.
The number of attendees cannot exceed the room's capacity.
Implement a method to find available rooms for a given time period.
Write a method to schedule a meeting if the room is available.

Specifications:
The time should be represented in hours (e.g., 9, 10 for 9:00 AM, 10:00 AM).
Use a 24-hour clock format.
Provide a basic command-line interface or sample main method to test your implementation.
*
* 1. Have  Hash Map with the Unique Meeting Room.
* 2. If the request comes with more than the capacity of room then reject it.
* 3. Method to retrieve time slots for a given period.
* 4. Method to schedule a meeting for the room available.
*
*
*
* Flow:
*
* 1. User will send the request with Time slot , number of people
* 2. Method to return Available rooms by number of people
* 3. Method to return rooms available by the time slot.
*
*
*
* Hash Map<Name, HashMap<Capacity, Slots>>
  Intervals[5,6]
* Slots <Intervals>

*
* [5,6] , 30
*
* Rooms info= [1, [30, slots]] -- [4,5] [5,6]  -- start from
*
* 1. Check the HAsh map for the room which has capacity of 30
*    --> get 1
*    --> get the slots form the map.
*    --> Iterate each interval whether the start time and the start ime in interval is match or not , if so
*    --> Return  the room number and the slot is booked
*
* -----
*
* Rooms not available
*
*  2. Check the Hash map for the room which has capacity of 30
    * Rooms info= [1, [30, slots]] -- [4,5] [5,6]  -- start from
   --> get the slots it takes O(N) times
   --> iterating each map in the hash map takes time.
   --> MOve the Hashmap to an Object
   --> Get hte Object find the interval and the capacity matches athen book the Hotel.
   *
   *
   *
   *
   *
   * Final Approch is:
   *  1. Have a Object with A unique name.
A capacity.
A booking has:
A meeting room.
A start time and end time.
A list of attendees.
   *
   ** 2. POpulate the ohject with appropriate values.
   * 3. Get the request with Interval and capacity .
   * 4. Iterate the obect and send the response.
   *
   *
   * -- available [5,6]
   *
   *
* */
public class Sample1 {
    public static void main(String[] args) {

        Booking booking1 = new Booking(3, 4);
        Booking booking2 = new Booking(4, 5);
        Booking booking3 = new Booking(5, 6);
        Booking booking4 = new Booking(6, 7);
        Booking booking5 = new Booking(7, 8);

        List<Booking> bookingList1=new ArrayList<>();
        List<Booking> bookingList2=new ArrayList<>();
        List<Booking> bookingList3=new ArrayList<>();
        List<Booking> bookingList4=new ArrayList<>();
        List<Booking> bookingList5=new ArrayList<>();

        bookingList1.add(booking1);
        bookingList2.add(booking2);
        bookingList3.add(booking3);
        bookingList4.add(booking4);
        bookingList5.add(booking5);

        MeetingRooms room1=new MeetingRooms("room1", 23,bookingList1);
        MeetingRooms room2=new MeetingRooms("room2", 40,bookingList2);
        MeetingRooms room3=new MeetingRooms("room3", 31,bookingList3);
        MeetingRooms room4=new MeetingRooms("room4", 23,bookingList4);
        MeetingRooms room5=new MeetingRooms("room5", 23,bookingList5);


           List<MeetingRooms> list=new ArrayList<MeetingRooms>();
           list.add(room1);
           list.add(room2);
           list.add(room3);
           list.add(room4);
           list.add(room5);
        MeetingScheduler scheduler=new MeetingScheduler(list);


        System.out.println(scheduler.bookMeeting(2,3, 23,"room1"));
        System.out.println(scheduler.bookMeeting(4,5, 20, "room2"));
        System.out.println(scheduler.bookMeeting(11,12, 20 , "room3"));
        System.out.println(scheduler.bookMeeting(13,14, 20, "room4"));
        System.out.println(scheduler.bookMeeting(15,16, 20, "room5"));
        System.out.println(scheduler.bookAnyMeeting(17,18, 30));

    }
}
