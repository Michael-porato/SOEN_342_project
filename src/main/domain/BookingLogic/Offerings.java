package src.main.domain;
import java.time.LocalDateTime;


public class Offerings{
    private double duration;
    private boolean availability;
    private String mode;
    private LocalDateTime startTime;     
    private LocalDateTime endTime;
    
    public Offerings(double duration, boolean availability, String mode, LocalDateTime startTime,
            LocalDateTime endTime) {
        this.duration = duration;
        this.availability = availability;
        this.mode = mode;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
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
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }     

    
}