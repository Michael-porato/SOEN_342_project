package domain.Users;

import java.util.ArrayList;
import java.util.List;

import domain.BookingLogic.Booking;

public class Client extends User{
    
public  List<Booking> bookings;



public Client(int userId, String name, String email, String username, String password) {
        super(userId, name, email, username, password);
        this.bookings = new ArrayList<>();
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

}
