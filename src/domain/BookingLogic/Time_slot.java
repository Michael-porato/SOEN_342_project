package domain.BookingLogic;

import java.time.LocalDateTime;

public class Time_slot {

    public LocalDateTime start_time;
    public LocalDateTime end_time;

    public Time_slot(LocalDateTime start_time, LocalDateTime end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }


    public boolean overlaps(LocalDateTime otherStart, LocalDateTime otherEnd) {
        return !(otherEnd.isBefore(start_time) || otherStart.isAfter(end_time));
    }
    
}
