import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import domain.BookingLogic.Booking;
import domain.BookingLogic.Lesson;
import domain.BookingLogic.Offerings;
import domain.BookingLogic.Room;
import domain.Users.Administrator;
import domain.Users.Client;
import domain.Users.Instructor;
import domain.Users.User;
import domain.BookingLogic.Location;
import domain.BookingLogic.Schedule;
import domain.BookingLogic.Time_slot;

static HashMap<String, String> users = new HashMap<>();
static ArrayList<Offerings> offerings = new ArrayList<>();
static ArrayList<User> usersList = new ArrayList<>();



public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);
    boolean var8 = false;
    Booking booking = null;

    User user = null;

    String var1 = "clientUser"; // Placeholder client username
    String var2 = "clientPass"; // Placeholder client password
    String var3 = "adminUser"; // Placeholder administrator username
    String var4 = "adminPass"; // Placeholder administrator password
    String var5 = "instructorUser"; // Placeholder instructor username
    String var6 = "instructorPass"; // Placeholder instructor password

    while (!var8) {


        if (user instanceof Administrator) {

            System.out.println("--Admin Menu--");
            System.out.println("8.  Create offering");
            System.out.println("9.  View Bookings");
            System.out.println("10. Cancel Booking");
            System.out.println("11. Delete account of instuctor");
            System.out.println("12. Delete account of client");
            System.out.println("13. Logout");
            System.out.println("Choose an option: ");
            


        } else if (user instanceof Client) {

            System.out.println("--Client Menu--");
            System.out.println("14. Make a booking");
            System.out.println("15. View bookings");
            System.out.println("16. Logout");



        } else if (user instanceof Instructor) {
            System.out.println("20. View available offerings");
            System.out.println("21. Claim on offering");
            System.out.println("22. Instructor offerings");
            System.out.println("23. Logout");
            System.out.println("Choose an option:");

        } else {
            guestMenu();
        }

        int choice = keyIn.nextInt();
        keyIn.nextLine();

        if (choice == 1) {
            System.out.println("Login Menu:");
            System.out.println("5. Login as Client");
            System.out.println("6. Login as Administrator");
            System.out.println("7. Login as Instructor");
            System.out.print("Choose your role to log in: ");

            int login_choice = keyIn.nextInt();
            keyIn.nextLine(); // Consume newline

            String login_username, login_password;

            if (login_choice == 5) {
                System.out.print("Enter Client username: ");
                login_username = keyIn.nextLine();
                System.out.print("Enter Client password: ");
                login_password = keyIn.nextLine();

                if (login_username.equals(var1) && login_password.equals(var2)) {
                    System.out.println("Client login successful!");
                    user = new Client(1, "Client Name", "client@example.com", login_username, login_password);
                    continue;
                } else {
                    System.out.println("Incorrect username or password for Client.");
                }

            } else if (login_choice == 6) {

                System.out.print("Enter Administrator username: ");
                login_username = keyIn.nextLine();
                System.out.print("Enter Administrator password: ");
                login_password = keyIn.nextLine();

                if (login_username.equals(var3) && login_password.equals(var4)) {
                    user = new Administrator(2, "Admin Name", "admin@example.com", login_username, login_password);

                    System.out.println("Administrator login successful!\n");
                    continue;
                } else {
                    System.out.println("Incorrect username or password for Administrator.");
                }

            } else if (login_choice == 7) {
                System.out.print("Enter Instructor username: ");
                login_username = keyIn.nextLine();
                System.out.print("Enter Instructor password: ");
                login_password = keyIn.nextLine();

                if (login_username.equals(var5) && login_password.equals(var6)) {
                    user = new Instructor(3, "Instructor Name", "instructor@example.com", login_username,
                            login_password, "Instructor Phone", "Instructor Specialization");
                    System.out.println("Instructor login successful!");
                } else {
                    System.out.println("Incorrect username or password for Instructor.");
                }

            } else {
                System.out.println("Invalid choice. Returning to the main menu.");
            }
            continue;

        } else if (choice == 2) {
            Client newClient = registerAsClient(1, "New Client", "newclient@example.com", "newUsername", "newPassword");
            usersList.add(newClient); // Add the newly registered client to the user list
            

            System.out.println("Account created successfully as Client!");

        } else if (choice == 3) {
            for(int i =0;i<offerings.size();i++){
                System.out.print("Offering "+(i)+ " "+ offerings.get(i));
            }
        
        } else if (choice == 4) {
            var8 = true;
            System.out.println("Exiting the system.");

        
        }

        if(choice == 8){

    
            String mode = "Private";

            List<Lesson> lessonsList = new ArrayList<>();
            lessonsList.add(new Lesson("Tennis", null));  
            lessonsList.add(new Lesson("Boxing", null));
            lessonsList.add(new Lesson("Yoga", null));

            

            System.out.println("Please enter the start time of the offering in the format yyyy-dd-MM:HH:");
            String startTimeInput = keyIn.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM:HH");
            LocalDateTime startTime = LocalDateTime.parse(startTimeInput, formatter);


            System.out.println("Please enter the end time of the offering in the format yyyy-dd-MM:HH:");
            String endTimeInput = keyIn.nextLine();
            LocalDateTime endTime = LocalDateTime.parse(endTimeInput, formatter);


        
            System.out.println("Select a lesson from the available list:");
            for (int i = 0; i < lessonsList.size(); i++) {
                System.out.println((i + 1) + ": " + lessonsList.get(i).getType());
            }
            int lessonChoice = keyIn.nextInt();
            Lesson selectedLesson = lessonsList.get(lessonChoice - 1);
            keyIn.nextLine();
            
            // Select room
            System.out.println("Enter the room (Swimming pool, Yoga studio):");
            String type = keyIn.nextLine();    
            System.out.println("Enter the location city:");
            String city = keyIn.nextLine();
            System.out.println("Enter the location province/state:");
            String province = keyIn.next();
            
            // Initialize Location
            Location location = new Location(city, province, lessonsList);
            
            // Initialize Schedule
            Schedule schedule = new Schedule();
            System.out.println("Enter the number of time slots for this schedule:");
            int timeSlotCount = keyIn.nextInt();
            keyIn.nextLine(); // Consume leftover newline
            
            for (int i = 0; i < timeSlotCount; i++) {
                System.out.println("Enter start time for time slot " + (i + 1) + " (yyyy-dd-MM:HH):");
                String slotStartInput = keyIn.nextLine();
                LocalDateTime slotStart = LocalDateTime.parse(slotStartInput, formatter);
            
                System.out.println("Enter end time for time slot " + (i + 1) + " (yyyy-dd-MM:HH):");
                String slotEndInput = keyIn.nextLine();
                LocalDateTime slotEnd = LocalDateTime.parse(slotEndInput, formatter);
            
                schedule.addTimeSlot(new Time_slot(slotStart, slotEnd));
            }
            
            // Create Room
            Room room = new Room(location, startTime, endTime, schedule, type);
            
            // Check room availability
            if (!schedule.isRoomAvailable(startTime, endTime)) {
                System.out.println("Room is not available for the selected time slot.");
            } else {
                System.out.println("Room is available. Proceeding to create offering.");
            

            
                Offerings offering = new Offerings(mode, startTime, endTime, room, selectedLesson, false, 1);
                offerings.add(offering);
            
                System.out.println("Offering created successfully: " + offering);
                continue;
            }
            continue;

            }
            
            

            if (choice == 9){


            }

            if(choice == 10){


            }

            if(choice == 11){


            }

            if(choice == 12){

                
            }


            if(choice == 13){

                System.out.println("Logging out...");
                user = null; 
                continue;
            }



            if (choice == 14) {
                

                
                for(int i =0;i<offerings.size();i++){
                    System.out.print("Offering "+(i)+ " "+ offerings.get(i));
                }

                System.out.println("\n ");
                System.out.println("Select the offering you want: ");
                int offeringInput = keyIn.nextInt();

                Client client = new Client(1,"Adam","adam@gmail.com"," "," ");

                booking = new Booking("1",client,offerings.get(offeringInput),"Available");
            
                } 
            if(choice == 15){
                System.out.println("Your offerings:");
                System.out.println(booking);
            }

            if(choice ==16){
                System.out.println("Logging out...");
                user = null; 
                continue;

            }
            



            if (choice == 20){

                for(int i =0;i<offerings.size();i++){
                    System.out.print("Offering "+(i)+ " "+ offerings.get(i));
                }
            }


            if(choice == 21){

                for(int i =0;i<offerings.size();i++){
                    System.out.print("Offering "+(i)+ " "+ offerings.get(i));
                }
                System.out.println("\n");
                System.out.println("Select the offering you want: ");
                int offeringInput = keyIn.nextInt();
                
                Offerings o = offerings.get(offeringInput);

                Instructor i = new Instructor(1,"Michael","51436452643","m@gmail.com"," "," ","swim");

                o.setInstructor(i);

                offerings.remove(offeringInput);

                offerings.add(o);

                System.out.println("\n+"+o);
                

            }

            if(choice == 22){
               
            }

            if(choice == 23){
                System.out.println("Logging out...");
                user = null; 
                continue;
            }
        
        
        
        
        
  
        
    

    }
}

public static void guestMenu() {
    System.out.println("--Guest Menu--");
    System.out.println("1. Login");
    System.out.println("2. Create Account as Client");
    System.out.println("3. View Offerings");
    System.out.println("4. Exit");
    System.out.print("Choose an option: ");
}


public static void viewOfferings() {
    System.out.println("Available Offerings:");
    for (int i = 0; i < offerings.size(); i++) {
        Offerings offering = offerings.get(i);
        if (offering.isAvailability()) {
            System.out.println("Lesson: " + offering.getLesson().getType() + 
                               ", Mode: " + offering.getMode() + 
                               ", Start Time: " + offering.getStartTime());
        }
    }
}


public static Client registerAsClient(int userId, String name, String email, String username, String password) {
    Client newClient = new Client(userId, name, email, username, password);
    System.out.println("Client registered: " + name);
    return newClient;
}


public void makeBooking(Offerings offering, Client client) {
    if (offering.isAvailability()) {
        offering.setAvailability(false); // Mark the offering as booked
        client.addBooking(new Booking(offering)); // Add to client's bookings
        System.out.println("Booking confirmed for " + offering.getLesson().getType() + " on " + offering.getStartTime());
    } else {
        System.out.println("Sorry, this offering is already booked.");
    }
}


public static void viewClientOfferings(ArrayList<Offerings> offerings) {
    System.out.println("Available Offerings:");
    for (int i = 0; i < offerings.size(); i++) {
        Offerings offering = offerings.get(i);
        if (offering.isAvailability()) {
            System.out.println(i + ": Lesson: " + offering.getLesson().getType() +
                               ", Mode: " + offering.getMode() +
                               ", Start Time: " + offering.getStartTime());
        }
    }
}

public static void makeClientBooking(Offerings offering, Client client) {
    if (offering.isAvailability()) {
        offering.setAvailability(false);  // Mark the offering as booked
        client.addBooking(new Booking(offering)); // Add to client's bookings
        System.out.println("Booking confirmed for " + offering.getLesson().getType() + " on " + offering.getStartTime());
    } else {
        System.out.println("Sorry, this offering is already booked.");
    }
}







