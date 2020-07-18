package com.epam.maven_oops;

public class Chocolates implements NewYearGift {
	public int price;
	public int weight;
	public Chocolates(int price, int weight) {
		super();
		this.price = price;
		this.weight = weight;
	}
	public int getPrice() {
		return price;
	}
	public int getWeight() {
		return weight;
	}
}
