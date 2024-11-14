package domain.BookingLogic;

import java.util.ArrayList;

public class Schedule {

   public ArrayList<Time_slot> time_slots = new ArrayList<>();


   public boolean isRoomAvailable(Offerings offering) {
    for (int i = 0; i < time_slots.size(); i++) {  // Traditional for loop
        Time_slot slot = time_slots.get(i);  // Accessing the element at index i
        if (offering.getStartTime().isBefore(slot.end_time) &&
            offering.getStartTime().isAfter(slot.start_time) ||
            offering.getStartTime().equals(slot.start_time)) {
            return false; // There is an overlap
        }
    }
    return true; // No overlap found
}
    
}
