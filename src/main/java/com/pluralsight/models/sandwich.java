package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private final String bread;
    private final int size;
    private boolean toasted;
    private final List<Topping> toppings = new ArrayList<>();
    private final String name = " MTA Sub"; // 💥 new name

    public Sandwich(String bread, int size) {
        this.bread = bread;
        this.size = size;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void addTopping(Topping t) {
        toppings.add(t);
    }

    public double getPrice() {
        double base = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0;
        };
        double toppingCost = toppings.stream().mapToDouble(Topping::getPrice).sum();
        return base + toppingCost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + size + "\" " + bread + (toasted ? ", Toasted" : "") + ") - $" +
                String.format("%.2f", getPrice());
    }
}
