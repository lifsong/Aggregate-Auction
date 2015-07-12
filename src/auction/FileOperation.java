package auction;
/* 1990-09-10  lifsong  initial version, but basic file operations not done yet, empty methods 1st
 * 1996-09-13  eric  add last close price get 
 * 1996-09-15  fred  add buying price get
 * 1996-09-19  simon  add selling price get
 * 1996-09-21  lifsong add comments for newcomer
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class FileOperation {
	/* closePriceFilename */
	private static final String closePriceFilename = "./resources/ClosePrice.csv";
	/* buyingInfoFilename */
	private static final String buyingInfoFilename = "./resources/Buying.csv";
	/* sellingInfoFilename */
	private static final String sellingInfoFilename = "./resources/Selling.csv";

	/* header of close price CSV file */
	private static final String[] CLOSE_PRICE_HEADER = { "stock_id", "price" };
	/* header of close price CSV file */
	private static final String[] BUYING_INFO_HEADER = { "buyer_id", "stock_id", "price", "count", "time" };
	/* header of selling info CSV file */
	private static final String[] SELLING_INFO_HEADER = { "seller_id", "stock_id", "price", "count", "time" };

	/* valid delegate time definitions */
	private static final String VALID_DELEGATE_START_TIME = "09:15:00";
	private static final String VALID_DELEGATE_END_TIME = "09:24:59";

	public final static String getClosePriceFilename() {
		return closePriceFilename;
	}

	public final static String getBuyingInfoFilename() {
		return buyingInfoFilename;
	}

	public final static String getSellingInfoFilename() {
		return sellingInfoFilename;
	}

	public boolean isFileExisting(String filename) {
		return new File(filename).exists();
	}

	public void deleteFile(String filename) {
		File f = new File(filename);
		if (f.exists()) {
			f.delete();
		}
	}

	public void renameFile(String filename, String newFilename) {
		File f = new File(filename);
		File nf = new File(newFilename);

		if (f.exists()) {
			f.renameTo(nf);
		}
	}


	public ArrayList<Selling> getAllSellingInfo() {
		FileReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(SELLING_INFO_HEADER);
		ArrayList<Selling> sellingInfo = new ArrayList<Selling>();

		try {
			fileReader = new FileReader(sellingInfoFilename);
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = csvRecords.get(i);
				Selling selling = new Selling(Integer.parseInt(record.get(SELLING_INFO_HEADER[0])),
						Integer.parseInt(record.get(SELLING_INFO_HEADER[1])),
						Float.parseFloat(record.get(SELLING_INFO_HEADER[2])),
						Integer.parseInt(record.get(SELLING_INFO_HEADER[3])), record.get(SELLING_INFO_HEADER[4]));
				if (isValidDelegate4Auction(selling.stockID, selling.price, selling.time)) {
					sellingInfo.add(selling);
				}
			}

			for (Selling selling : sellingInfo) {
				System.out.println(selling.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sellingInfo;
	}

	public ArrayList<Buying> getAllBuyingInfo() {
		FileReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(BUYING_INFO_HEADER);
		ArrayList<Buying> buyingInfo = new ArrayList<Buying>();

		try {
			fileReader = new FileReader(buyingInfoFilename);
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = csvRecords.get(i);
				Buying buying = new Buying(Integer.parseInt(record.get(BUYING_INFO_HEADER[0])),
						Integer.parseInt(record.get(BUYING_INFO_HEADER[1])),
						Float.parseFloat(record.get(BUYING_INFO_HEADER[2])),
						Integer.parseInt(record.get(BUYING_INFO_HEADER[3])), record.get(BUYING_INFO_HEADER[4]));
				if (isValidDelegate4Auction(buying.stockID, buying.price, buying.time)) {
					buyingInfo.add(buying);
				}
			}

			for (Buying buying : buyingInfo) {
				System.out.println(buying.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return buyingInfo;
	}

	public ArrayList<ClosePrice> getAllClosePrices() {
		FileReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(CLOSE_PRICE_HEADER);
		ArrayList<ClosePrice> closePrices = new ArrayList<ClosePrice>();

		try {
			fileReader = new FileReader(closePriceFilename);
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = csvRecords.get(i);
				ClosePrice closePrice = new ClosePrice(Integer.parseInt(record.get(CLOSE_PRICE_HEADER[0])),
						Float.parseFloat(record.get(CLOSE_PRICE_HEADER[1])));
				closePrices.add(closePrice);
			}

			for (ClosePrice closePrice : closePrices) {
				System.out.println(closePrice.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return closePrices;
	}
	
	public float getClosePrice(int stockID) {
		ArrayList<ClosePrice> closePrices = getAllClosePrices();
		for (ClosePrice closePrice : closePrices) {
			if(closePrice.stockID == stockID ){
				return closePrice.closePrice;
			}
		}
		
		System.err.println("Close price not found for stock " + stockID);
		return 999999.0f;
	}

	private boolean isValidDelegate4Auction(int stockID, float price, String delegateTime) {
		if (delegateTime.compareTo(VALID_DELEGATE_START_TIME) < 0
				|| delegateTime.compareTo(VALID_DELEGATE_END_TIME) > 0) {
			return false;
		}

		if( price/getClosePrice(stockID) > 1.1001 || price/getClosePrice(stockID) < 0.8999){
			return false;
		}
		return true;
	}
}
