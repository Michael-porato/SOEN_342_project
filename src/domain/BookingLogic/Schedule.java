package domain.BookingLogic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

   public List<Time_slot> time_slots;

   public Schedule() {
    time_slots = new ArrayList<>();
}

public List<Time_slot> getTimeSlots() {
    return time_slots;
}

public void addTimeSlot(Time_slot timeSlot) {
    time_slots.add(timeSlot);
}

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
