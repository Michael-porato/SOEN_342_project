package main.Interface;

import java.util.HashMap;
import java.util.Scanner;



public class Main {

    static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);
        boolean var8 = false;

        String var1 = "clientUser";      // Placeholder client username
        String var2 = "clientPass";      // Placeholder client password
        String var3 = "adminUser";       // Placeholder administrator username
        String var4 = "adminPass";       // Placeholder administrator password
        String var5 = "instructorUser";  // Placeholder instructor username
        String var6 = "instructorPass";  // Placeholder instructor password

        while (!var8) {
            System.out.println("Guest Menu:");
            System.out.println("1. Login");
            System.out.println("2. Create Account as Client");
            System.out.println("3. View Offerings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = keyIn.nextInt();
            keyIn.nextLine(); // Consume newline
            
            if (choice == 1) {
                System.out.println("Login Menu:");
                System.out.println("1. Login as Client");
                System.out.println("2. Login as Administrator");
                System.out.println("3. Login as Instructor");
                System.out.print("Choose your role to log in: ");
                
                int login_choice = keyIn.nextInt();
                keyIn.nextLine(); // Consume newline

                String login_username, login_password;

                if (login_choice == 1) {
                    System.out.print("Enter Client username: ");
                    login_username = keyIn.nextLine();
                    System.out.print("Enter Client password: ");
                    login_password = keyIn.nextLine();

                    if (login_username.equals(var1) && login_password.equals(var2)) {
                        System.out.println("Client login successful!");
                    } else {
                        System.out.println("Incorrect username or password for Client.");
                    }

                } else if (login_choice == 2) {
                    System.out.print("Enter Administrator username: ");
                    login_username = keyIn.nextLine();
                    System.out.print("Enter Administrator password: ");
                    login_password = keyIn.nextLine();

                    if (login_username.equals(var3) && login_password.equals(var4)) {
                        System.out.println("Administrator login successful!");
                    } else {
                        System.out.println("Incorrect username or password for Administrator.");
                    }

                } else if (login_choice == 3) {
                    System.out.print("Enter Instructor username: ");
                    login_username = keyIn.nextLine();
                    System.out.print("Enter Instructor password: ");
                    login_password = keyIn.nextLine();

                    if (login_username.equals(var5) && login_password.equals(var6)) {
                        System.out.println("Instructor login successful!");
                    } else {
                        System.out.println("Incorrect username or password for Instructor.");
                    }

                } else {
                    System.out.println("Invalid choice. Returning to the main menu.");
                }

            } else if (choice == 2) {
                String new_user, new_pass;
                System.out.print("Enter a username for the new Client: ");
                new_user = keyIn.nextLine();
                System.out.print("Enter a password for the new Client: ");
                new_pass = keyIn.nextLine();

                users.put(new_user, new_pass);

                System.out.println("Account created successfully as Client!");

            } else if (choice == 3) {
                System.out.println("Viewing available offerings...");
                // Logic to view offerings goes here

            } else if (choice == 4) {
                var8 = true;
                System.out.println("Exiting the system.");

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        keyIn.close();
    }
}


