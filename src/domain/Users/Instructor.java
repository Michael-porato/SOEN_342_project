package domain.Users;



import java.util.ArrayList;
import java.util.List;

import domain.BookingLogic.Availability;

public class Instructor extends User{
    

    
    public String phone_number;
    public String specialization;
    public List<Availability> availability;
    


    public Instructor(int userID, String name, String phone_number, String email, String username, String password, String specialization){

        super(userID, name, email, username, password);
        this.phone_number = phone_number; 
        this.specialization = specialization;
        this.availability = new ArrayList<>(); 

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

    


}