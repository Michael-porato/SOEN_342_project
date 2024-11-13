package main.domain.BookingLogic;

import main.domain.Users.Client;

public class Booking {
    private String bookingId;       
    private Client client;            
    private Offerings offerings;        
    private String status;            

   
    public Booking(String bookingId, Client client, Offerings offerings, String status) {
        this.bookingId = bookingId;     
        this.client = client;            
        this.offerings = offerings;          
        this.status = status;              
    }



    public String getBookingId() {
        return bookingId;
    }

    public Client getClient() {
        return client; 
    }

    public Offerings getOffering() {
        return offerings; 
    }

    public String getStatus() {
        return status; 
    }

    // Setters
    public void setStatus(String status) {
        this.status = status; 
    }

    
}
