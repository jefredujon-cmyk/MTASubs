package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private final String bread;
    private final Size size;
    private boolean toasted;
    private final List<Topping> toppings = new ArrayList<>();
    private final String name = "MTA Sub"; // Name for your sandwich

    // ✅ Constructor now accepts Size enum
    public Sandwich(String bread, Size size) {
        this.bread = bread;
        this.size = size;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void addTopping(Topping t) {
        toppings.add(t);
    }

    // ✅ Price now comes directly from Size enum
    public double getPrice() {
        double base = size.getPrice();  // Uses enum price
        double toppingCost = toppings.stream().mapToDouble(Topping::getPrice).sum();
        return base + toppingCost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + size.toString() + " " + bread + (toasted ? ", Toasted" : "") + ") - $" +
                String.format("%.2f", getPrice());
    }
}
