package medium;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * @author WeiCuicui
 *
 */
public class CountNumsWithUniqueDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;
		System.out.println(countNumbersWithUniqueDigits(n));
	}
	
	/**
	 * 利用组合，动态规划
	 * n = 0, 0 <= x < 1, 只有一个,num = 1
	 * n = 1, 0 <= x < 10, 共10个,num = 10
	 * n = 2, 0 <= x < 100, 两位数的情况，_ _ 第一位不能为0，有9种选择，第二位除了不能与第一位相同外，共9中选择，因此 num = 9*9 + 10 = 81;
	 * n = 3, 0 <= x < 1000, 三位数的情况， _ _ _ 第一位9种，第二位9种，第三位8种，因此 num = 9*9*8 + 81 + 10 = 749;
	 * n = 4, 0 <= x < 10000, 四位数的情况，_ _ _ _ 第一位9种，第二位9种，第三位8种，第四位7种，因此num = 9*9*8*7 + 749 + 81 + 10；
	 * 以此类推，当为n位数时，求出总数
	 * @param n
	 * @return
	 */
	public static int countNumbersWithUniqueDigits(int n) {//时间复杂度是O(1)，因为n不可能超过10，超过10找不到不重复的数
		
		if(n > 10)
			return 0;
		if(n == 0)
			return 1;
		/*//递归
		int base = 9;
		for(int i = 2; i <= n; i++){
			base = base * (11 - i);
		}
		return base + countNumbersWithUniqueDigits(n - 1);*/
		
		//迭代
		int base = 9;
		int num = 10;
		for(int i = 2; i <= n; i++){
			base = base * (11 - i); 
			num = num + base;
		}
		return num;
	}

}
