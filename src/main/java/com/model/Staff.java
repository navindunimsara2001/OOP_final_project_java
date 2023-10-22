package com.model;

public class Staff extends Person {
    private boolean isManager;

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public void setRole(boolean role) {
    	if(role = true) {
    		isManager = true;
    	}
    	else {
    		isManager = false;
    	}
    }
    
    public boolean getRole() {
    	return isManager;
    }
}
