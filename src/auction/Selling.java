package auction;

import java.util.Date;

public class Selling {
	public int sellerID;
	public int stockID;
	public float price;
	public int count;
	public String time;	
	
	public Selling(int sellerID, int stockID, float price, int count, String time){
		this.sellerID = sellerID;
		this.stockID = stockID;
		this.price = price;
		this.count = count;
		this.time = time;
	}
	
	public String toString(){
		return "Selling: " + sellerID + ", " + stockID + ", " + price + ", " + count + ", " +  time;
	}
}
