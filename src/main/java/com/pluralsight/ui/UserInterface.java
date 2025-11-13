package com.pluralsight.ui;
import com.pluralsight.models.Order;

import java.util.Scanner;

// ------------------------------------------------------------
// Main.java
// Entry point for the Sandwich Shop Ordering System
// Handles the main menu, order creation, and user navigation
// ------------------------------------------------------------


public class UserInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("====================================");
        System.out.println("   🥪 Welcome to the Sandwich Shop!  ");
        System.out.println("====================================");

        while (running) {
            System.out.println("\n🏠 Home Screen");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Order order = new Order();
                    order.start(scanner);
                    break;
                case "0":
                    System.out.println("Goodbye! 👋");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}


