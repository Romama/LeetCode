package medium;
/**
 * 只能进行一次交易
 * 买入后，卖出，求最大的利润
 * 定义一个变量记录第i天前卖出的最大利润max，一个变量记录到第i天为止，出现的最低价格minPrice，作为买入价格。
 * 初始化 max = 0，minPrice = prices[0]
 * 从i = 1开始遍历数组（i表示在第i天卖出）
 * 每次更新max和minPrice
 * @author Administrator
 *
 */
public class BestTimetoBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {5,9,3,4,6,7,2,10};
		System.out.println(maxProfit(prices));

	}
	
	/**
	 * 类似动态规划
	 * 时间复杂度 O(n),遍历一遍数组。
	 * 空间复杂度O(1)
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices){
		if(prices == null || prices.length == 0)
			return 0;
		int profit = 0; //最大利润
		int minElement = prices[0]; //初始化最小元素
		for(int i = 1; i < prices.length; i++){ 
			profit = Math.max(profit, prices[i] - minElement);
			minElement = Math.min(prices[i], minElement);
		}
		
		return profit;
	}

}
