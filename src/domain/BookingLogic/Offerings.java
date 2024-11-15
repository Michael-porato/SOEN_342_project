package domain.BookingLogic;

import java.time.LocalDateTime;

import domain.Users.Instructor;

public class Offerings{
    
    public boolean availability;
    public String mode;
    public LocalDateTime startTime;
    public LocalDateTime endTime;     
    public Instructor instructor;
    public Room room;
    public Lesson lesson;

    
    public Offerings(String mode, LocalDateTime startTime,
            LocalDateTime endTime, Room room, Lesson lesson) {
        
        this.availability = false;
        this.mode = mode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.instructor = null;
        this.room = room;
        this.lesson = lesson;
    }

    
    public boolean isAvailability() {
        return availability && room.getSchedule().isRoomAvailable(startTime, endTime);  // Check room availability
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
    public LocalDateTime getEndTime(){
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime){
        this.endTime = endTime;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void assignInstructor(Instructor instructor) {
        this.instructor = instructor;
        this.availability = true;  // Set availability to true when an instructor is assigned
    }

    public String toString() {
        return "Offering{" +
                "lessonType='" + lesson.type + '\'' +
                ", mode='" + mode + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + room.end_time +
                ", isAvailable=" + availability +
                '}';
    }

    

    
}