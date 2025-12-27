package MeetingBookingScheduler;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MeetingScheduler {
private List<MeetingRooms> rooms;

public MeetingScheduler(List<MeetingRooms> rooms) {
    this.rooms = rooms;
}


public MeetingRooms findFirstAvailableRoom(int startTime, int endTime,int attendees) {
    for(MeetingRooms room : rooms) {
        if(room.isAvailable(startTime,endTime) && room.getCapacity() >= attendees)
            return room;
    }
    return null;
}

public MeetingRooms findIsRoomAvailable(int startTime, int endTime,int attendees, String name) {

    for(MeetingRooms room : rooms) {
         if(room.getName().equals(name)) {
             if(room.isAvailable(startTime,endTime) && room.getCapacity() >= attendees)
                 return room;
         }
         }
        return null;
    }

public String bookAnyMeeting(int startTime, int endTime,int attendees) {
    if(attendees == 0) return "Booking failed: No attendees provided.";
    MeetingRooms room = findFirstAvailableRoom(startTime,endTime,attendees);

    if(room != null){
        return room.bookRoom(startTime,endTime,attendees);
    }
    return "Booking Failed: No rooms available.";
}

    public String bookMeeting(int startTime, int endTime,int attendees, String name) {
        if(attendees == 0) return "Booking failed: No attendees provided.";
        MeetingRooms room = findIsRoomAvailable(startTime,endTime,attendees,name);

        if(room != null){
            return room.bookRoom(startTime,endTime,attendees);
        }
        return "Booking Failed: No rooms available.";
    }
}
