package domain.BookingLogic;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Schedule {

   public ArrayList<Time_slot> time_slots = new ArrayList<>();


   public boolean isRoomAvailable(LocalDateTime startTime, LocalDateTime endTime) {
    // Traditional for loop using the index
    for (int i = 0; i < time_slots.size(); i++) {
        Time_slot slot = time_slots.get(i);  // Accessing each Time_slot by index
        if (startTime.isBefore(slot.getEnd_time()) && endTime.isAfter(slot.getStart_time())) {
            return false;  // Overlap found, room is not available
        }
    }
    return true;  // No overlap, room is available
}
    
}
