package com.model;

public class Item {
	//Attributes
	private int ID;
	private String name;
	private int inStock;
	
	// getters & setters
	public int getInStock() {
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
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
}
