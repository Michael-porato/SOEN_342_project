package domain.Users;

import java.util.ArrayList;
import java.util.List;
import domain.BookingLogic.Availability;
import domain.BookingLogic.Offerings;

public class Instructor extends User{
    

    
    public String phone_number;
    public String specialization;
    public List<Availability> availability;
    private List<Offerings> claimedOfferings; 
    


    public Instructor(int userID, String name, String phone_number, String email, String username, String password, String specialization){

        super(userID, name, email, username, password);
        this.phone_number = phone_number; 
        this.specialization = specialization;
        this.availability = new ArrayList<>();
        this.claimedOfferings = new ArrayList<>(); 

    }


    public String getPhone_number(){
        return phone_number;
    }

    public String getSpecialization(){
        return specialization;
    }

    public List<Availability> getAvailability(){
        return availability;
    }


    public void setPhone_number(String phone_number){
        if (phone_number.matches("\\d{10}")) {
            this.phone_number = phone_number;
        } else {
            System.out.println("Invalid phone number. Please enter a 10-digit number.");
        }
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }


      
    public void addAvailability(Availability avail) {
        availability.add(avail);                   
    }

    
    public void removeAvailability(Availability avail) {
        availability.remove(avail);             
    }

    public void addOffering(Offerings offering) {
        claimedOfferings.add(offering);
    }

    public List<Offerings> getClaimedOfferings() {
        return claimedOfferings;
    }

    public void showInstructorOfferings() {
        if (claimedOfferings.isEmpty()) {
            System.out.println("This instructor has not claimed any offerings.");
        } else {
            for (Offerings offering : claimedOfferings) {
                System.out.println("Claimed Offering: " + offering.getLesson().getType());
            }
        }
    }


    public void claimOffering(Offerings offering) {
        if (offering.isAvailability()) {
            offering.setAvailability(false); // Mark as unavailable
            claimedOfferings.add(offering);
            System.out.println("Offering claimed: " + offering.getLesson().getType());
        } else {
            System.out.println("Offering is already claimed by another instructor.");
        }
    }

    


}
