package src.main.domain;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Predefined correct credentials for different roles
        String storedClientUsername = "client123";
        String storedClientPassword = "clientpass";
        
        String storedAdminUsername = "admin123";
        String storedAdminPassword = "adminpass";
        
        String storedInstructorUsername = "instructor123";
        String storedInstructorPassword = "instructorpass";

        // Create a scanner to get user input
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        // Start guest menu
        while (!exit) {
            System.out.println("Guest Menu:");
            System.out.println("1. Login");
            System.out.println("2. Create Account as Client");
            System.out.println("3. View Offerings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            // Main menu logic with if-else
            if (choice == 1) {
                // Login option
                System.out.println("Login Menu:");
                System.out.println("1. Login as Client");
                System.out.println("2. Login as Administrator");
                System.out.println("3. Login as Instructor");
                System.out.print("Choose your role to log in: ");
                int loginChoice = scanner.nextInt();
                scanner.nextLine();  

               
                if (loginChoice == 1) {
                    // Client login
                    System.out.print("Enter Client username: ");
                    String clientUsername = scanner.nextLine();
                    System.out.print("Enter Client password: ");
                    String clientPassword = scanner.nextLine();
                    
                    if (clientUsername.equals(storedClientUsername) && clientPassword.equals(storedClientPassword)) {
                        System.out.println("Client login successful!");
                    } else {
                        System.out.println("Incorrect username or password for Client.");
                    }
                } else if (loginChoice == 2) {
                    // Administrator login
                    System.out.print("Enter Administrator username: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Enter Administrator password: ");
                    String adminPassword = scanner.nextLine();
                    
                    if (adminUsername.equals(storedAdminUsername) && adminPassword.equals(storedAdminPassword)) {
                        System.out.println("Administrator login successful!");
                    } else {
                        System.out.println("Incorrect username or password for Administrator.");
                    }
                } else if (loginChoice == 3) {
                    // Instructor login
                    System.out.print("Enter Instructor username: ");
                    String instructorUsername = scanner.nextLine();
                    System.out.print("Enter Instructor password: ");
                    String instructorPassword = scanner.nextLine();
                    
                    if (instructorUsername.equals(storedInstructorUsername) && instructorPassword.equals(storedInstructorPassword)) {
                        System.out.println("Instructor login successful!");
                    } else {
                        System.out.println("Incorrect username or password for Instructor.");
                    }
                } else {
                    System.out.println("Invalid choice. Returning to the main menu.");
                }
            } else if (choice == 2) {
                // Create account as Client
                System.out.print("Enter a username for the new Client: ");
                String newClientUsername = scanner.nextLine();
                System.out.print("Enter a password for the new Client: ");
                String newClientPassword = scanner.nextLine();
                
                // In a real application, here you would store the new client credentials
                System.out.println("Account created successfully as Client!");
            } else if (choice == 3) {
                // View offerings
                System.out.println("Viewing available offerings...");
                // You can display some offerings here
            } else if (choice == 4) {
                // Exit the program
                exit = true;
                System.out.println("Exiting the system.");
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}


