package basics;

/**
 * 给一个整数，判断它是不是3的指数
 * @author Administrator
 *
 */
public class PowerOfThree {

	public static void main(String[] args){
		int n = 272;
		System.out.println(isPowerOfThree_2(n));
	}
	
	/**
	 * 循环
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThree(int n){
		if(n <= 0)
			return false;
		while(n % 3 == 0){
			n = n / 3;
		}
		if(n != 1) return false;
		return true;
	}
	
	/**
	 * 没有使用循环，利用数学知识
	 * 求出int类型的整数中3的最高次幂，记作x
	 * 则 x % n == 0，因为x和n都是3的整数次幂，且 x >= n
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThree_1(int n ){
		if(n <= 0)
			return false;
		int x = (int)Math.pow(3, (int)(Math.log(Integer.MAX_VALUE) / Math.log(3))); //计算出3的幂的最大值，3的幂必须为整数
		return x % n == 0;
		
	}
	
	/**
	 * 直接根据n和3求解幂，
	 * 若得到的幂不是整数，则返回false
	 * % 1 是否为0
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThree_2(int n){
		  if(n <= 0)
			  return false;
		  double x = (Math.log10(n) / Math.log10(3)) ; //求出3的幂，这里结果必须为double类型，并且必须采用log10
		  boolean flag = x % 1 == 0;//x应该是 >= 0的整数
		  
		  return  flag; 
	}
}
