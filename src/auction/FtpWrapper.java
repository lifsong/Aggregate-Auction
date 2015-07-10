package auction;

/* 1990-09-10  lifsong  initial version, but basic ftp operations not done yet, empty methods 1st
 * 1996-09-13  eric  add last close price get 
 * 1996-09-15  fred  add buying price get
 * 1996-09-19  simon  add selling price get
 * 1996-09-21  lifsong add comments for newcomer
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FtpWrapper {

	/* FTP server configuration */
	private String serverIP = "127.0.0.1";
	private int serverPort = 21;

	/* closePriceFileName */
	private static final String closePriceFile = "/mount/data/closePrice.csv";
	/* sellingInfoFileName */
	private static final String sellingInfoFile = "/mount/data/sellingInfo.csv";
	/* sellingInfoFileName */
	private static final String buyingInfoFile = "/mount/data/buyingInfo.csv";
	/* localFilePath */
	private static final String localFilePath = "/tmp/";

	public static String getClosePriceFilename() {
		return closePriceFile;
	}

	public static String getSellingInfoFilename() {
		return sellingInfoFile;
	}

	public static String getBuyingInfoFilename() {
		return buyingInfoFile;
	}

	public boolean isFtpFileExisting(String filename) {
		/*lines of code here
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		return true;
	}

	public boolean getFile2Local(String filename) {
		/*lines of code here
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		return true;
	}

	public float getLastClosePrice(int stockID) {
		/*lines of code here
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */	
		return 15.0f;
	}

	public Set<Integer> getSellingStocks() {
		/*lines of code here
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */		
		return new HashSet<Integer>();
	}

	public Set<Integer> getBuyingStocks() {
		/*lines of code here
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		return new HashSet<Integer>();
	}

	public ArrayList<Selling> getSellingInfo(int stockID) {
		/*lines of code here
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 *
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		return new ArrayList<Selling>();
	}

	public ArrayList<Buying> getBuyingInfo(int stockID) {
		/*lines of code here
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		return new ArrayList<Buying>();
	}
}
