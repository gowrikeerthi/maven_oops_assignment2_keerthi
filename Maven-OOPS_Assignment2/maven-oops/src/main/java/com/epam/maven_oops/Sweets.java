package com.epam.maven_oops;

public class Sweets implements NewYearGift {
	public int weight;
	public int price;
	public Sweets(int sweetWeight, int sweetPrice) {
		super();
		this.weight = sweetWeight;
		this.price = sweetPrice;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int sweetWeight) {
		this.weight = sweetWeight;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int sweetPrice) {
		this.price = sweetPrice;
	}
	
}
