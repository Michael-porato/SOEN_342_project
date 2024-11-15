import java.time.LocalDateTime;
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
            System.out.println("Choose an option: ");
            


        } else if (user instanceof Client) {

            System.out.println("--Client Menu--");
            System.out.println("13. View offerings and make a booking");


        } else if (user instanceof Instructor) {
            System.out.print("I AM AN INSTRUCTOR");

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
            viewOfferings(); // Call the method to view offerings
            continue;
        
        } else if (choice == 4) {
            var8 = true;
            System.out.println("Exiting the system.");

        } else {
            System.out.println("Invalid option. Please try again.");
        }

        if(choice == 8){

    
            String mode = "Private";
            LocalDateTime startTime = LocalDateTime.of(2024, 11, 14, 11, 0); // Adjust date and time as needed
            LocalDateTime endTime = LocalDateTime.of(2024, 11, 14, 12, 0);
        
            // Create a list of lessons to initialize Location
            ArrayList<Lesson> lessonsList = new ArrayList<>();
            
            // Initialize Location with city, province, and an empty list of lessons
            Location location = new Location("New York", "NY", lessonsList);
        
            // Create Schedule and add Time_slots if necessary
            Schedule schedule = new Schedule();
            schedule.time_slots.add(new Time_slot(
                LocalDateTime.of(2024, 11, 14, 9, 0), // Example existing time slot start
                LocalDateTime.of(2024, 11, 14, 10, 0) // Example existing time slot end
            ));
            schedule.time_slots.add(new Time_slot(
                LocalDateTime.of(2024, 11, 14, 13, 0),
                LocalDateTime.of(2024, 11, 14, 14, 0)
            ));
        
            // Create Room with location, start_time, end_time, and schedule
            Room room = new Room(location, startTime, endTime, schedule);
        
            // Check room availability before proceeding (optional)
            if (!schedule.isRoomAvailable(new Offerings(mode, startTime, endTime, room, new Lesson("Yoga", new Instructor(1, "John Doe", "1234567890", "john.doe@example.com", "johndoe", "password123", "Yoga"))).getStartTime(), new Offerings(mode, startTime, endTime, room, new Lesson("Yoga", new Instructor(1, "John Doe", "1234567890", "john.doe@example.com", "johndoe", "password123", "Yoga"))).getEndTime())) {
                System.out.println("Room is not available for the selected time slot.");
            }
             else {
                // Create the Instructor and Lesson objects
                Instructor instructor = new Instructor(
                    /*userID=*/1, 
                    /*name=*/"John Doe", 
                    /*phone_number=*/"1234567890", 
                    /*email=*/"john.doe@example.com", 
                    /*username=*/"johndoe", 
                    /*password=*/"password123", 
                    /*specialization=*/"Yoga"
                );
                Lesson lesson = new Lesson("Yoga", instructor);
        
                // Initialize the offerings list
                ArrayList<Offerings> offeringsList = new ArrayList<>();
        
                // Call the createOffering method
                Offerings offering = Administrator.createOffering(mode, startTime, endTime, room, offeringsList, lesson);

                offeringsList.add(offering);  // Automatically adds to the global list

                // Return the created offering
                System.out.println("Offering created: " + offering);
        
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

            if (choice == 13) {
                viewClientOfferings(offerings);  // Assuming offerings is a list of available offerings
    
                // Prompt client to choose an offering to book
                System.out.print("Enter the number of the offering you want to book: ");
                int offeringChoice = keyIn.nextInt();
                keyIn.nextLine();  // Consume newline
                
                if (offeringChoice >= 0 && offeringChoice < offerings.size()) {
                    // Select the chosen offering
                    Offerings selectedOffering = offerings.get(offeringChoice);
                    
                    // Call the method to make the booking
                    makeClientBooking(selectedOffering, (Client) user);  // This is where you make the booking
                    
                } else {
                    System.out.println("Invalid offering number.");
                }
        }
    }


    keyIn.close();
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
    




