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
        Admin;

        public static Role byId(int id) {
            if (id < 0 || id > 2) {
                throw new RuntimeException("Invalid value for role: " + id);
            }
            return Role.values()[id];
        }

    }

    @Override
    public String toString() {
        return "Staff{" +
                "role=" + role +
                "} " + super.toString();
    }
}
