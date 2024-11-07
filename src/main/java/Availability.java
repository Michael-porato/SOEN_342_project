import java.time.LocalTime;

public class Availability {
    private String day;        
    private LocalTime startTime;
    private LocalTime endTime;   

    // Constructor
    public Availability(String day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters
    public String getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    // Optional: Method to check if a specific time is within this availability
    public boolean isAvailable(LocalTime time) {
        return !time.isBefore(startTime) && !time.isAfter(endTime);
    }
}