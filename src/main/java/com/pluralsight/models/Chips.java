package com.pluralsight.models;

public class Chips {
    private final String name;

    public Chips(String name) {
        this.name = name;
    }

    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return "Chips: " + name + " - $" + String.format("%.2f", getPrice());
    }
}

