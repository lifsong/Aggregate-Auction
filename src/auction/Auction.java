package auction;
/* 1990-09-10  lifsong  initial version
 * 1996-09-13  fred  add check if file exists 
 * 1996-09-15  fred  add sorting buying info
 * 1996-09-19  simon add sorting selling info
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Auction implements Runnable {
	private static FileOperation fOp = new FileOperation();
	private static final float EPS = 1e-2f;

	@Override
	public void run() {

		while (true) {
			System.out.println("Auction app is running!");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (isTime2Run()) {
				/* pre-condition: ask if the files are existing */
				if (!fOp.isFileExisting(FileOperation.getClosePriceFilename())) {
					System.out.println("ClosePriceFile does not exist!");
					continue;
				} else if (!fOp.isFileExisting(FileOperation.getBuyingInfoFilename())) {
					System.out.println("BuyingInfoFile does not exist!");
					continue;
				} else if (!fOp.isFileExisting(FileOperation.getSellingInfoFilename())) {
					System.out.println("SellingInfoFile does not exist!");
					continue;
				}

				/* get buying info and sort */
				ArrayList<Buying> buyingInfo = fOp.getAllBuyingInfo();
				sortBuyingInfo(buyingInfo);
				/* get selling info and sort */
				ArrayList<Selling> sellingInfo = fOp.getAllSellingInfo();
				sortSellingInfo(sellingInfo);

				/* get close prices */
				ArrayList<ClosePrice> closePrices = fOp.getAllClosePrices();

				/*
				 * ToDo: filter out stocks which exist only in one of buying or
				 * selling list.
				 */

				/* ToDo: do the aggregation auction */

				/* ToDo: update the matrix screen */
			}
		}
	}

	private boolean isTime2Run() {
		Calendar c = Calendar.getInstance();
		if (c.get(Calendar.HOUR_OF_DAY) != 9) {
			return false;
		}

		if ((c.get(Calendar.MINUTE) < 25) || (c.get(Calendar.MINUTE) >= 30)) {
			return false;
		}
		return true;
	}

	private Set<Integer> findTradingStocks(Set<Integer> sellingStocks, Set<Integer> buyingStocks) {
		Set<Integer> mySet = new HashSet<Integer>();
		for (Integer i : sellingStocks) {
			for (Integer j : buyingStocks) {
				if (i.intValue() == j.intValue()) {
					mySet.add(i);
				}
			}
		}
		return mySet;
	}

	private class SortBuyingInfo implements Comparator<Buying> {
		@Override
		public int compare(Buying buy1, Buying buy2) {
			if (Math.abs(buy1.price - buy2.price) < EPS) {
				return buy1.time.compareTo(buy2.time);
			}

			if (buy1.price > buy2.price) {
				return -1;
			} else if (buy1.price < buy2.price) {
				return 1;
			}
			return 0;
		}
	}

	private void sortBuyingInfo(ArrayList<Buying> buyingInfo) {
		Collections.sort(buyingInfo, new SortBuyingInfo());
		for (Buying buy : buyingInfo) {
			System.out.println(buy);
		}
	}

	private class SortSellingInfo implements Comparator<Selling> {
		@Override
		public int compare(Selling sell1, Selling sell2) {
			if (Math.abs(sell1.price - sell2.price) < EPS) {
				return sell1.time.compareTo(sell2.time);
			}

			if (sell1.price < sell2.price) {
				return -1;
			} else if (sell1.price > sell2.price) {
				return 1;
			}
			return 0;
		}
	}
	
	private void sortSellingInfo(ArrayList<Selling> sellingInfo) {
		Collections.sort(sellingInfo, new SortSellingInfo());
		for (Selling sell : sellingInfo) {
			System.out.println(sell);
		}
	}

}
