package medium;

/**
 *  给出一组不同面值，及一个总值
 *  求最少需要多少个来拼凑出总值
 *  Example 1:
	coins = [1, 2, 5], amount = 11
	return 3 (11 = 5 + 5 + 1)
	
	Example 2:
	coins = [2], amount = 3
	return -1.

 * 动态规划
 * 我们维护一个一维动态数组dp，其中dp[i]表示钱数为i时的最小硬币数的找零，递推式为：dp[i] = min(dp[i], dp[i - coins[j]] + 1);
      其中coins[j]为第j个硬币，而i - coins[j]为钱数i减去其中一个硬币的值，剩余的钱数在dp数组中找到值，然后加1和当前dp数组中的值做比较，取较小的那个更新dp数组。
 */
public class CoinChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins = {2,5,6};
		int amount = 16;
		System.out.println(coinChange(coins, amount));
	}
	
	//生成和为amount的最少coin个数
	public static int coinChange(int[] coins, int amount) {
		int dp[] = new int[amount + 1];   //存储局部和，当和为i时需要的最少硬币数目
        final int INF = Integer.MAX_VALUE - 1;  //int类型的最大值，也可以设为 0x7ffffffe，补码形式，符号位为0
        for (int i = 1; i <= amount; i++) dp[i] = INF;   //初始化，除了dp[0] = 0之外，其它的都是最大值
        
        for (int i = 0; i <= amount; i++) {  
            for (int j = 0; j < coins.length; j++) {  
                if (i + coins[j] <= amount) {
                	//i==0时，将和为coins[i]本身的dp设置为1；当和为i时，比较dp[i + coins[j]] 与 dp[i] + 1，选取二者中的较小值
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
                }
            }  
        }  
        return dp[amount] == INF ? -1 : dp[amount];   
	}
}
