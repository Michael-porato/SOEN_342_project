package domain.BookingLogic;

import java.time.LocalDateTime;

import domain.Users.Client;


public class Booking {
    public String bookingId;       
    public Client client;            
    public Offerings offerings;        
    public String status;
    private LocalDateTime bookingTime;            

   
    public Booking(String bookingId, Client client, Offerings offerings, String status) {
        this.bookingId = bookingId;     
        this.client = client;            
        this.offerings = offerings;          
        this.status = status;              
    }

    public Booking(Offerings offering) {
        this.bookingTime = LocalDateTime.now(); // Set the booking time as now
    }


    public String getBookingId() {
        return bookingId;
    }


    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }


    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
    }


    public Offerings getOfferings() {
        return offerings;
    }


    public void setOfferings(Offerings offerings) {
        this.offerings = offerings;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public String toString(){
        return "This booking is for offering: "+ this.offerings.toString()+ " and for client: "+ this.client.toString();
    }





    
}
