package com.pluralsight.models;

public enum Size {

    ROLL(5.0, "ROLL"),
    SIDEKICK(12.0, "SIDEKICK"),
    HERO(15.0, "HERO");

    private final double price;
    private final String displayName;

    Size(double price, String displayName) {
        this.price = price;
        this.displayName = displayName;
    }

    public double getPrice() {
        return price;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
