package arrays;

/**
 * 在1的基础上，最多可以进行两次交易。前提：最多只能同时持有一支股票
 * @author Administrator
 *
 */
public class BestTimetoBuyAndSellStockIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = {5,9,3,4,6,7,2,10};
		System.out.println(maxProfit(prices));
	}
	
	/**
	 * 将数组分为两部分，分别对这两部分按照1中的方法求解最大利润preProfit，postProfit，
	 * 然后遍历数组，求取两部分和的最大值max。
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
       
    	if(prices == null || prices.length <= 1)
    		return 0;
    	int maxProfit = 0;
    	int[] preProfit = new int[prices.length];
    	int[] postProfit = new int[prices.length];
    	
    	/**
    	 * 从前往后遍历，i越大，时间越靠后。寻找最小的以买入                                                              
    	 */
    	int minPrice = prices[0];
    	for(int i = 1; i < prices.length;i++){
    		minPrice = Math.min(minPrice, prices[i]);
    		preProfit[i] = Math.max(preProfit[i - 1], prices[i] - minPrice);
    		
    	}
    	
    	/**
    	 * 从后向前遍历，i越小，表示时间越向前。寻找最大的以卖出
    	 */
    	int curMax = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
        	curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);   
        }
    	
        //preProfit[i] 前i天最大利润，postProfit[i]：后 （n - i）天的最大利润
    	for(int i = 0; i < prices.length;i++){
    		maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
    	}
    	
    	return maxProfit;
    }
}
