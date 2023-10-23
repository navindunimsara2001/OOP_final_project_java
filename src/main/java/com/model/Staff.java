package com.model;

public class Staff extends Person {
    private int isManager;

    public void setRole(int role) {
        if (role == 1) {
            isManager = 1;
        } else {
            isManager = 0;
        }
    }

    public int getRole() {
        return isManager;
    }
}
