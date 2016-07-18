package medium;


/**
 * Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; 
 * given n = 13, return 2 because 13 = 4 + 9.
 * @author Administrator
 */
public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 19;
		System.out.println(getPerfectSquare(x));
	}
	
	/**
	 * perfect squares，动态规划
	 * @param n 为正整数
	 * @return
	 */
	public static int getPerfectSquare(int n){
		if(n <= 0)
			return 0;
		
		//数字i能够拆分的最少完全平方数
		int[] dp = new int[n + 1];
		for(int k = 1; k <= n; ++k)
			dp[k] = Integer.MAX_VALUE;
		//这个必须初始化为0
		dp[0] = 0;
		//动态规划，求1-n之间的每个数能拆分的最小平方数
		for(int i = 1; i <= n; ++i){
			for(int j = 1; j * j <= i; ++j){
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		
		return dp[n];
	}

}
