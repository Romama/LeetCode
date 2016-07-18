package medium;

/**
 * 整数拆分
 * @author Administrator
 * Given a positive integer n, break it into the sum of at least two positive integers 
 * and maximize the product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * 
 * 6 = 2 + 2 + 2 = 3 + 3. But 2 * 2 * 2 < 3 * 3.
 * Therefore, if there are three 2's in the decomposition, 
 * we can replace them by two 3's to gain a larger product.
 * 因此，若将一个整数拆分为乘积最大的几个整数，则拆分成的这些整数中最多有2个2，因为若有3个2时，一定会被3*3替代。除了3之外，其它的数都为3
 */
public class IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 10;
		System.out.println(numOfIntegerBreak(n));
	}
	
	/**
	 * 最差时间复杂度：O(n)
	 * n是大于2小于58的整数
	 * 所有的因子都是2或者3
	 * @param n
	 * @return
	 */
	public static int numOfIntegerBreak(int n){
		//找规律：2:1;3:2;4:4;5:2*3;6:3*3;7:3*4;8:3*3*2;
		if(n < 2)
			return 0;
		if(n == 2)
			return 1;
		if(n == 3)
			return 2;
	
		int result = 1;
		while(n > 4){
			result = result * 3;
			n = n - 3;
		}
		return result * n;
	}

}
