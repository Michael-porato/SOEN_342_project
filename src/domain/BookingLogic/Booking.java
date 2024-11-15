package domain.BookingLogic;

import domain.Users.Client;


public class Booking {
    public String bookingId;       
    public Client client;            
    public Offerings offerings;        
    public String status;            

   
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

    
    public void setStatus(String status) {
        this.status = status; 
    }

    
}
