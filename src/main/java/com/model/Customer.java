package com.model;

public class Customer extends Person {
    // attributes
    private String gender;
    private String district;

    // getters & setters


    public String getGender() {
        return gender;
    }

    public String getDistrict() {
        return district;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

}
