package domain.Users;

import java.util.ArrayList;
import java.util.List;
import domain.BookingLogic.Booking;
import domain.BookingLogic.Offerings;

public class Client extends User{
    
public  List<Booking> bookings;
public int age;

public Client(int userId, String name, String email, String username, String password) {
        super(userId, name, email, username, password);
        this.bookings = new ArrayList<>();
    }
    public Client(int userId, String name, String email, String username, String password, int a) {
        super(userId, name, email, username, password);
        this.bookings = new ArrayList<>();
        this.age=a;
    }



   
    public List<Booking> getBookings() {
        return bookings; 
    }
   
    public void addBooking(Booking booking) {
        bookings.add(booking); 
    }

    
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    // Optional: Method to view all bookings
    public void viewBookings() {
        System.out.println("Bookings for " + getName() + ":");
        for (Booking booking : bookings) {
            System.out.println(booking); 
        }
    }
    public boolean isUnderage(){
        return (this.age<18);
    }

    public void makeBooking(Offerings offering) {
        if (offering.isAvailability()) {
            offering.setAvailability(false); // Mark the offering as booked
            System.out.println("Booking confirmed for " + offering.getLesson().getType() + " at " + offering.getStartTime());
        }
        else if(this.isUnderage()){
            System.out.println("Client is underage, please book through legal guardian");
        }
        else {
            System.out.println("Sorry, this offering is already booked.");
        }
    }

    public String toString(){
        return this.name;
    }

}
