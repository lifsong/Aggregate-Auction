package auction;

/*The big screen( real HW ) in stock market hall shall show each stock's trade amount 
 * and open price at market opening */

public class MatrixScreen {

	public class StockPosition{
		private int page;
		private int row;
		
		public StockPosition(){
			this.page = 0;
			this.row = 0;
		}
		
		public int getPage(){
			return this.page;
		}
		
		public int getRow(){
			return this.row;
		}
	}
	
	public boolean clearScreen() {
		return true;
	}
	
	/* color = 1 green; color = 2 red */
	private boolean updateGridContent(int page, int x, int y, String text, int textColor) {
		/* talking with HW interface */
		/* 
		 * lines of code
		 */		
		return true;
	}

	public StockPosition getStockPosition(int stockID){
		return new StockPosition();
	}
	
	public boolean showStockInfo(String stockName, int stockID, StockPosition pos, float currentPrice, float openPrince,
			float increasePercentage, float strikeCount, float totalStrikePrice, float avarageStrikePrice, int textColor) {
		/*calling updateGridContent() to update screen buffer*/
		/* 
		 * lines of code
		 */
		return true;
	}
}
