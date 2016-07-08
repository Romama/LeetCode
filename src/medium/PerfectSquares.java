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

		int x = 12;
		System.out.println(getPerfectSquare(x));
	}
	
	/**
	 * 思路：利用求一个数的平方根，sqrt方法
	 * @param x
	 * @return
	 */
	public static int getPerfectSquare(int x){
		boolean flag = false;
		if(x < 0){
			flag = true;
			return -1;
		}
	
		double y = x;
		int count = 0;
		int num = (int)Math.sqrt(y);
		while(y >= 1){
			count++;
			y = y - num * num;
			num = (int)Math.sqrt(y);
		}
		
		return count;
	}

}
