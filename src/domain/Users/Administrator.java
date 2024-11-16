package domain.Users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import domain.BookingLogic.Lesson;
import domain.BookingLogic.Offerings;
import domain.BookingLogic.Room;

public class Administrator extends User {
    public ArrayList<Offerings> offerings; 
    

   
    public Administrator(int userId, String name, String email, String username, String password) {
        super(userId, name, email, username, password);
        this.offerings = new ArrayList<>(); 
    }

    
    public List<Offerings> getOfferings() {
        return offerings;
    }


    
    public void removeOffering(Offerings offering) {
        offerings.remove(offering);
    }

    
    public void viewOfferings() {
        System.out.println("Offerings managed by " + getName() + ":");
        for (Offerings offering : offerings) {
            System.out.println(offering); 
        }
    }


    public static Offerings createOffering(String mode, LocalDateTime startTime, LocalDateTime endTime, Room room, ArrayList<Offerings> offeringsList, Lesson lesson, boolean published) {
       
        Offerings offering = new Offerings(mode, startTime, endTime, room, lesson, published, 1);
        offeringsList.add(offering); // Add to a list available to all instructors
        return offering;
    }

    public void deleteUser (User user, List <User> usersList){
        usersList.remove(user);
    }
}
