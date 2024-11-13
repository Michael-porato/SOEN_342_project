package main.Interface;

import java.util.Scanner;



public class Main {
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
            
            int choice1 = keyIn.nextInt();
            keyIn.nextLine(); // Consume newline
            
            if (choice1 == 1) {
                System.out.println("Login Menu:");
                System.out.println("1. Login as Client");
                System.out.println("2. Login as Administrator");
                System.out.println("3. Login as Instructor");
                System.out.print("Choose your role to log in: ");
                
                int choice2 = keyIn.nextInt();
                keyIn.nextLine(); // Consume newline
                
                String var11, var12;

                if (choice2 == 1) {
                    System.out.print("Enter Client username: ");
                    var11 = keyIn.nextLine();
                    System.out.print("Enter Client password: ");
                    var12 = keyIn.nextLine();

                    if (var11.equals(var1) && var12.equals(var2)) {
                        System.out.println("Client login successful!");
                    } else {
                        System.out.println("Incorrect username or password for Client.");
                    }

                } else if (choice2 == 2) {
                    System.out.print("Enter Administrator username: ");
                    var11 = keyIn.nextLine();
                    System.out.print("Enter Administrator password: ");
                    var12 = keyIn.nextLine();

                    if (var11.equals(var3) && var12.equals(var4)) {
                        System.out.println("Administrator login successful!");
                    } else {
                        System.out.println("Incorrect username or password for Administrator.");
                    }

                } else if (choice2 == 3) {
                    System.out.print("Enter Instructor username: ");
                    var11 = keyIn.nextLine();
                    System.out.print("Enter Instructor password: ");
                    var12 = keyIn.nextLine();

                    if (var11.equals(var5) && var12.equals(var6)) {
                        System.out.println("Instructor login successful!");
                    } else {
                        System.out.println("Incorrect username or password for Instructor.");
                    }

                } else {
                    System.out.println("Invalid choice. Returning to the main menu.");
                }

            } else if (choice1 == 2) {
                System.out.print("Enter a username for the new Client: ");
                String var10 = keyIn.nextLine();
                System.out.print("Enter a password for the new Client: ");
                var10 = keyIn.nextLine();
                System.out.println("Account created successfully as Client!");

            } else if (choice1 == 3) {
                System.out.println("Viewing available offerings...");
                // Logic to view offerings goes here

            } else if (choice1 == 4) {
                var8 = true;
                System.out.println("Exiting the system.");

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        keyIn.close();
    }
}


