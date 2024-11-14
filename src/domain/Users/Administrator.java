package domain.Users;

import java.util.ArrayList;
import java.util.List;

import domain.BookingLogic.Offerings;

public class Administrator extends User {
    public List<Offerings> offerings; 

   
    public Administrator(int userId, String name, String email, String username, String password) {
        super(userId, name, email, username, password);
        this.offerings = new ArrayList<>(); 
    }

    
    public List<Offerings> getOfferings() {
        return offerings;
    }

    
    public void addOffering(Offerings offering) {
        offerings.add(offering);
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

    
    public void deleteUser(User user) {
        
        System.out.println("User " + user.getName() + " has been deleted."); 
    }

    
}
