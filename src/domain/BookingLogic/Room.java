package domain.BookingLogic;

import java.time.LocalDateTime;


public class Room {

    public Location location;
    public LocalDateTime start_time;
    public LocalDateTime end_time;
    public Schedule schedule; 
    
    
    public Room (Location location, LocalDateTime start_time, LocalDateTime end_time, Schedule schedule ){

        this.location = location;
        this.start_time = start_time;
        this.end_time = end_time;
        this.schedule = schedule;


    }


    public Location getLocation() {
        return location;
    }


    public void setLocation(Location location) {
        this.location = location;
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


    public Schedule getSchedule() {
        return schedule;
    }


    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    
    
    



    
}
