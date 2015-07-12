package auction;

public class ClosePrice {
	public int stockID;
	public float closePrice;
	
	public ClosePrice(int stockID, float closePrice){
		this.stockID = stockID;
		this.closePrice = closePrice;
	}
	
	public String toString(){
		return "ClosePrice: " + stockID + ", " + closePrice;
	}
}
