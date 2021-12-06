package models;

public class orders {
	private String Item;

	private int Quantity;

	private String CardNumber;

	public orders() {
	}

	public orders(String Item, int Quantity, String CardNumber) {
		this.Item = Item;
		this.Quantity = Quantity;
		this.CardNumber = CardNumber;
	}

	public String getItem() {
		return Item;
	}

	public int getQuantity() {
		return Quantity;
	}

	public String getCardNumber() {
		return CardNumber;
	}

}