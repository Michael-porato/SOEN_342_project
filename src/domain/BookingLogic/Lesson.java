package domain.BookingLogic;

import java.time.LocalDateTime;

import domain.Users.Instructor;

public class Lesson {
    public String lessonId;             
    public String type;               
    public LocalDateTime startTime;     
    public LocalDateTime endTime;     
    public Location location;           
    public Instructor instructor;       

    // Constructor
    public Lesson(String lessonId, String type, LocalDateTime startTime, LocalDateTime endTime, Location location, Instructor instructor) {
        this.lessonId = lessonId;           
        this.type = type;                    
        this.startTime = startTime;            
        this.endTime = endTime;               
        this.location = location;               
        this.instructor = instructor;         
    }

    public Lesson(String type, Instructor instructor) {
        this.type = type;
        this.instructor = instructor;
    }

    
    public String getLessonId() {
        return lessonId; 
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime; 
    }

    public Location getLocation() {
        return location; 
    }

    public Instructor getInstructor() {
        return instructor; 
    }

   
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor; 
    }

    public void setLocation(Location location) {
        this.location = location; 
    }

    
}
