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
    public boolean published;
    public int capacity;

    
    public Offerings(String mode, LocalDateTime startTime, LocalDateTime endTime, Room room, Lesson lesson, boolean published, int capacity) {
        
        this.availability = false;
        this.mode = mode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.instructor = null;
        this.room = room;
        this.lesson = lesson;
        this.published = false;
        this.capacity =capacity;
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

    public void setInstructor(Instructor i){
        this.instructor = i;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }




    public void assignInstructor(Instructor instructor) {
        this.instructor = instructor;
        this.availability = true;  // Set availability to true when an instructor is assigned
        this.published = true;
    }

    public String toString() {

        var iName ="";
        if(this.instructor == null){
            iName = "Not Set";
        }
        else{
            iName = this.instructor.getName();
        }

        

        return "Offering{" +
                "lessonType='" + lesson.type + '\'' +
                ", mode='" + mode + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + room.end_time +
                ", isAvailable=" + availability +
                ", Instructor = "+iName+
                '}';
    }

    

    
}