package com.pluralsight.models;

//Enumeration (Enum) used to represent group of named constants(ex day of week Mon-Sun will never change)
public enum Size {

    //Enum constants for our sizes, will set price based on size, hold name for our questionableBurgers

    //Small will set  price to 5
   ROLL(5.0, "ROLL."),

    //Medium will set price to 12
    SIDEKICK(12.0,"SIDEKICK"),

    //HERO will set  price to 15
    HERO(15.0, "HERO");

    //We need to set a base price and name for each size, name will only be for pattys
    private final double price;
    private final String name;

    //Create constructor
    Size(double price, String name){
        this.price = price;
        this.name = name;
    }

    //Overload constructor so the drinks and side arent named per size
    Size(double price){
        this.price = price;
        this.name = null;
    }

    //Gotta get them getters
    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    //To string to turn SIZE into Size format
    @Override
    public String toString(){
        String lowCase = name().toLowerCase();
        return Character.toUpperCase(lowCase.charAt(0)) + lowCase.substring(1);
    }

}