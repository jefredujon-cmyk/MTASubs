package com.pluralsight.models;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<Drink> drinks = new ArrayList<>();
    private final List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich s) { sandwiches.add(s); }
    public void addDrink(Drink d) { drinks.add(d); }
    public void addChips(Chips c) { chips.add(c); }

    public double getTotal() {
        double total = 0;
        for (Sandwich s : sandwiches) total += s.getPrice();
        for (Drink d : drinks) total += d.getPrice();
        for (Chips c : chips) total += c.getPrice();
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sandwich s : sandwiches) sb.append(s).append("\n");
        for (Drink d : drinks) sb.append(d).append("\n");
        for (Chips c : chips) sb.append(c).append("\n");
        sb.append("Total: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }

    public void start(Scanner scanner) {
    }
}



