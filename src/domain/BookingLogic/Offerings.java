package domain.BookingLogic;

import java.time.LocalDateTime;

import domain.Users.Instructor;

public class Offerings{
    
    public boolean availability;
    public String mode;
    public LocalDateTime startTime;     
    public Instructor instructor;
    public Room room;
    public Lesson lesson;

    
    public Offerings(String mode, LocalDateTime startTime,
            LocalDateTime endTime, Room room, Lesson lesson) {
        
        this.availability = false;
        this.mode = mode;
        this.startTime = startTime;
        this.instructor = null;
        this.room = room;
        this.lesson = lesson;
    }

    
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void assignInstructor(Instructor instructor) {
        this.instructor = instructor;
        this.availability = true;  // Set availability to true when an instructor is assigned
    }

    public boolean isAvailableForBooking() {
        return availability && instructor != null;  // Only available if instructor is assigned and availability is true
    }


    public String toString() {
        return "Offering: " + this.lesson.getType() + " (" + this.mode + "), " + 
               "Start Time: " + this.startTime + ", End Time: " + this.room.getEnd_time() + 
               ", Room: " + this.room.getLocation().getCity(); // Customize to your needs
    }

    

    
}