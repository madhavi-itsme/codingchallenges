package MeetingBookingScheduler;


public class Booking {

    private int starttime;
    private int endtime;

    public int getStarttime() {
        return starttime;
    }

    public int getEndtime() {
        return endtime;
    }

    public Booking(int starttime, int endtime) {
        this.starttime = starttime;
        this.endtime = endtime;
    }
}
