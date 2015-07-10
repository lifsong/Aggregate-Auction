package auction;

import java.util.HashSet;
import java.util.Set;

public class Auction {
	private static FtpWrapper ftpOp = new FtpWrapper();

	public void execute() {

		while (true) {

			/* pre-condition: the files should be existing */
			if (!ftpOp.isFtpFileExisting(FtpWrapper.getClosePriceFilename())) {
				/* sleep for 2sec */
				System.out.println("ClosePriceFile does not exist!");
				continue;
			} else if (!ftpOp.isFtpFileExisting(FtpWrapper.getBuyingInfoFilename())) {
				/* sleep for 2sec */
				System.out.println("BuyingInfoFile does not exist!");
				continue;
			} else if (!ftpOp.isFtpFileExisting(FtpWrapper.getSellingInfoFilename())) {
				/* sleep for 2sec */
				System.out.println("SellingInfoFile does not exist!");
				continue;
			}

			Set<Integer> sellingStocks = ftpOp.getSellingStocks();
			Set<Integer> buyingStocks = ftpOp.getBuyingStocks();
			Set<Integer> tradingStocks = findTradingStocks(sellingStocks, buyingStocks);

			/* get trading stocks' last day close price */

			/* do the aggregation auction if tradingStocks has content */

			/* update the matrix screen */
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
