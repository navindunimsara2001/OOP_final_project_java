package com.model;

public class Customer extends Person {
    // attributes
    private String DOB;
    private String password;
    private String gender;
    private String district;

    // getters & setters
    public String getDOB() {
        return DOB;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getDistrict() {
        return district;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

}
