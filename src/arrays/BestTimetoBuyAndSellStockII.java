package arrays;

/**
 * 与1不同的是，这里可以进行多次交易，即可以多次买卖股票，前提是最多同时持有一支股票。
 * 即在买入一支股票前，必须把持有的股票先卖掉
 * 方法：举例子，找出最大利润情况下，买卖的方法，从而得到规律。
 * @author Administrator
 */
public class BestTimetoBuyAndSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = {5,9,3,4,6,7,2,10};
		System.out.println(maxProfit(prices));
	}
	
	//可以多次买卖。在最大利润的情况下，每进行一次交易的情况必然是：前天的price小于后天的price。
    //不论相邻或者不相邻。例如：5,9,4,3,6,7 最大利润有两种买卖的方式：（（59,37），（59,36,67））
    //因此，遍历数组，只要后天的price大于前天，就可获得利润。
    public static int maxProfit(int[] prices) { 
        if(prices == null || prices.length == 0)
           return 0;
        int result = 0;
        int i = 0;
        int len = prices.length; 
        if(len < 2)
            return 0;
        for(i = 1;i < len; ++i)
        {
            if(prices[i] > prices[i - 1])
            {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }

}
