package com.model;

public class Appointment {
    private int ID;
    private String brand;
    private String model;
    private String year;
    private String type;
    private String date;

    // getters & setters
    public int getID() {
        return ID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }
}