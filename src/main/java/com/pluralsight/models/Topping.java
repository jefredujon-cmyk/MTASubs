package com.pluralsight.models;

public class Topping {
    private final String name;
    private final String type;
    private final int size;

    public Topping(String name, String type, Size size) {
        this.name = name;
        this.type = type.toLowerCase();
        this.size = size;
    }

    public double getPrice() {
        return switch (type) {
            case "meat" -> switch (size) {
                case 4 -> 1.00;
                case 8 -> 2.00;
                case 12 -> 3.00;
                default -> 0;
            };
            case "cheese" -> switch (size) {
                case 4 -> 0.75;
                case 8 -> 1.50;
                case 12 -> 2.25;
                default -> 0;
            };
            default -> 0; // regular or sauce = free
        };
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
