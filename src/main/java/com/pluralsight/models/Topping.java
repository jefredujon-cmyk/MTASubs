package com.pluralsight.models;

public class Topping {
    private final String name;
    private final String type; // "meat", "cheese", "regular", "sauce"
    private final Size size;   // ✅ Use Size enum

    public Topping(String name, String type, Size size) {
        this.name = name;
        this.type = type.toLowerCase();
        this.size = size;
    }

    public double getPrice() {
        switch (type) {
            case "meat":
                return switch (size) {
                    case ROLL -> 1.00;
                    case SIDEKICK -> 2.00;
                    case HERO -> 3.00;
                };
            case "cheese":
                return switch (size) {
                    case ROLL -> 0.75;
                    case SIDEKICK -> 1.50;
                    case HERO -> 2.25;
                };
            case "regular", "sauce":
                return 0.0; // included in base price
            default:
                return 0.0;
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        double price = getPrice();
        return name + (price > 0 ? " - $" + String.format("%.2f", price) : "");
    }
}
