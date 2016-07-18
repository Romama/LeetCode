package medium;

/**
 * 统计所有的素数
 * @author Administrator
 *
 */
public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 15;
		System.out.println(getAllPrimes(n));
	}
	
	/**
	 * 给定一个非负整数n，求小于n的所有素数
	 * @param n
	 * @return
	 */
	public static int getAllPrimes(int n){
		if(n <= 1) // 1是非质数、非合数
			return 0;
		boolean[] notPrime = new boolean[n]; //默认false
		int count = 0;
		for(int i = 2; i < n; ++i){
			if(!notPrime[i])
				count++;
			for(int j = 2; i * j < n; ++j){
				notPrime[i * j] = true;
			}
		}
		return count;
	}
}
