package com.model;

public class ItemRequest {
	
	// attributes
	private int ID;
	private Item itemId;
	private int qty;
	
	// getters & setters
	public int getID() {
		return ID;
	}
	public Item getItemId() {
		return itemId;
	}
	public int getQty() {
		return qty;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
