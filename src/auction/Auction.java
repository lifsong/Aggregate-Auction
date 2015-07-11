package auction;

import java.util.HashSet;
import java.util.Set;

public class Auction {
	private static FtpWrapper ftpOp = new FtpWrapper();

	public void execute() {

		while (true) {
			/*
			 * if system time is not within [9:25:00, 9:30:00) or today's
			 * aggregate auction was done already, skip checking
			 */
			if (true) {/*todo: implement it*/
				/* pre-condition: ask if the files are existing */
				if (!ftpOp.isFtpFileExisting(FtpWrapper.getClosePriceFilename())) {
					/* sleep for 2sec, wait for 3rd party to generate file */
					System.out.println("ClosePriceFile does not exist!");
					continue;
				} else if (!ftpOp.isFtpFileExisting(FtpWrapper.getBuyingInfoFilename())) {
					/* sleep for 2sec, wait for 3rd party to generate file */
					System.out.println("BuyingInfoFile does not exist!");
					continue;
				} else if (!ftpOp.isFtpFileExisting(FtpWrapper.getSellingInfoFilename())) {
					/* sleep for 2sec, wait for 3rd party to generate file */
					System.out.println("SellingInfoFile does not exist!");
					continue;
				}

				/* get trading stocks' last day close price */

				/*
				 * filter out invalid trades if time is invalid or price is out
				 * of pre-defined max range
				 */

				/* find stocks which have trades */
				Set<Integer> sellingStocks = ftpOp.getSellingStocks();
				Set<Integer> buyingStocks = ftpOp.getBuyingStocks();
				Set<Integer> tradingStocks = findTradingStocks(sellingStocks, buyingStocks);

				/* do the aggregation auction if tradingStocks has content */

				/* update the matrix screen */
			}
		}
	}

	private static Set<Integer> findTradingStocks(Set<Integer> sellingStocks, Set<Integer> buyingStocks) {
		Set<Integer> tradingStocks = new HashSet<Integer>();
		for (Integer selllingStock : sellingStocks) {
			for (Integer buyingStock : buyingStocks) {
				if (selllingStock.intValue() == buyingStock.intValue()) {
					tradingStocks.add(selllingStock);
				}
			}
		}
		return tradingStocks;
	}
}
