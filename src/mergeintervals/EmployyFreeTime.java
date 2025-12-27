package mergeintervals;

import java.util.ArrayList;
import java.util.List;

class Interval{
    int start;
    int end;
    boolean closed;
    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    // set the flag for closed/open
    public void setClosed(boolean closed)
    {
        this.closed = closed;
    }

}

public class EmployyFreeTime {
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        // Replace this placeholder return statement with your code

        List<Interval> ans = new ArrayList<Interval>();
        return ans;
    }
}
