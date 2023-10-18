package com.model;

public class Fuel {
    private int ID;
    private String type;
    private String subtype;
    private float amount;
    private double price;

    public String getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
