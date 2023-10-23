package com.model;

public class Item {
	//Attributes
	private int ID;
	private String name;
	private boolean inStock;
	
	// getters & setters
	public boolean isInStock() {
		return inStock;
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
}
