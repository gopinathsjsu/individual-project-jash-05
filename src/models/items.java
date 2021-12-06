package models;

public class items {
	private String category;

	private String name;

	private double price;

	private int quantityStock;

	public items() {
	}

	public items(String category, String name, double price, int quantityStock) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
	}

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantityStock() {
		return quantityStock;
	}

}