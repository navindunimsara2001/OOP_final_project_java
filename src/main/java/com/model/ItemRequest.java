package com.model;

public class ItemRequest {

    // attributes
    private int ID;
    private Item item;
    private String status;
    private int qty;
    private Staff staff;

    // getters & setters
    public int getID() {
        return ID;
    }

    public Item getItem() {
        return item;
    }

    public int getQty() {
        return qty;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ItemRequest{" +
                "ID=" + ID +
                ", item=" + item +
                ", qty=" + qty +
                ", staff=" + staff +
                '}';
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
