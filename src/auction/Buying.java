package auction;

public class Buying{
	public int buyerID;
	public int stockID;
	public float price;
	public int count;
	public String time;

	public Buying(int sellerID, int stockID, float price, int count, String time) {
		this.buyerID = sellerID;
		this.stockID = stockID;
		this.price = price;
		this.count = count;
		this.time = time;
	}

	public String toString() {
		return "Buying: " + buyerID + ", " + stockID + ", " + price + ", " + count + ", " + time;
	}

}
