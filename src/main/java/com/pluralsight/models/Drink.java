package com.pluralsight.models;

public class Drink {
    private final String name;
    private final String size;

    public Drink(String name, String size) {
        this.name = name;
        this.size = size.toLowerCase();
    }

    public double getPrice() {
        return switch (size) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "Drink: " + size + " " + name + " - $" + String.format("%.2f", getPrice());
    }
}

