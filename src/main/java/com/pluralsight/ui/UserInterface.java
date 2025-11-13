package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n🏠 Welcome to MTA SUBS);
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                handleOrder();
            } else if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private void handleOrder() {
        Order order = new Order();
        while (true) {
            System.out.println("\n🧺 Order Menu:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> order.addSandwich(createSandwich());
                case "2" -> order.addDrink(createDrink());
                case "3" -> order.addChips(createChips());
                case "4" -> checkout(order);
                case "0" -> {
                    System.out.println("Order canceled.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private Sandwich createSandwich() {
        System.out.print("Bread type (white/wheat/rye/wrap): ");
        String bread = scanner.nextLine();

        System.out.print("Size (4/8/12): ");
        int size = Integer.parseInt(scanner.nextLine());

        Sandwich sandwich = new Sandwich(bread, size);

        System.out.print("Toasted? (y/n): ");
        sandwich.setToasted(scanner.nextLine().equalsIgnoreCase("y"));

        // Add toppings
        System.out.println("Add meats (comma separated, e.g., ham,steak,bacon): ");
        String[] meats = scanner.nextLine().split(",");
        for (String meat : meats) {
            if (!meat.isBlank()) sandwich.addTopping(new Topping(meat.trim(), "meat", size));
        }

        System.out.println("Add cheeses (comma separated, e.g., cheddar,swiss): ");
        String[] cheeses = scanner.nextLine().split(",");
        for (String cheese : cheeses) {
            if (!cheese.isBlank()) sandwich.addTopping(new Topping(cheese.trim(), "cheese", size));
        }

        System.out.println("Add regular toppings (comma separated, e.g., lettuce,onions,tomato): ");
        String[] regulars = scanner.nextLine().split(",");
        for (String reg : regulars) {
            if (!reg.isBlank()) sandwich.addTopping(new Topping(reg.trim(), "regular", size));
        }

        System.out.println("Add sauces (comma separated, e.g., mayo,mustard): ");
        String[] sauces = scanner.nextLine().split(",");
        for (String sauce : sauces) {
            if (!sauce.isBlank()) sandwich.addTopping(new Topping(sauce.trim(), "sauce", size));
        }

        System.out.println("Sandwich added! Total so far: $" + sandwich.getPrice());
        return sandwich;
    }

    private Drink createDrink() {
        System.out.print("Drink flavor: ");
        String name = scanner.nextLine();
        System.out.print("Size (small/medium/large): ");
        String size = scanner.nextLine();
        return new Drink(name, size);
    }

    private Chips createChips() {
        System.out.print("Chip type: ");
        String name = scanner.nextLine();
        return new Chips(name);
    }

    private void checkout(Order order) {
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println(order);
        System.out.println("==========================");
        System.out.print("Confirm order? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            new ReceiptWriter().writeReceipt(order);
            System.out.println("Receipt saved. Thank you!");
        } else {
            System.out.println("Order canceled.");
        }
    }
}
