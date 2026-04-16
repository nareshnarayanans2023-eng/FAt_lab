package com.example;
public class Car extends Vehicle {
    private String modelName = "Mustang";
    public String getFullName() {
        return brand + " " + modelName;
    }
}
