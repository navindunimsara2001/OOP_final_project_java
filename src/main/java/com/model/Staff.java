package com.model;

public class Staff extends Person {
    private Role role;

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public enum Role {
        Staff,
        Manager,
        Admin
    }

    @Override
    public String toString() {
        return "Staff{" +
                "role=" + role +
                "} " + super.toString();
    }
}
