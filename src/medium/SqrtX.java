package medium;

/**
 * 给定一个int类型的数x，求这个数的平方根
 * @author Administrator
 *
 */
public class SqrtX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 方法一：
	 * 求x的平方根， 时间复杂度O(根号n)
	 * @param x
	 * @return
	 */
	public static int sqrt(int x){
		boolean flag = false;//标记是否是异常输入
		if(x < 0){
			flag = true;
			return -1;
		}
		if(x == 0)
			return 0;
		if(x == 1)
			return 1;
		int i = 1;
		//这种方法不需要担心Int越界的问题，因为这里作了 （ i <= x / i）的处理
		for(i = 1; i <= x / i; ++i){
			if(i * i == x)//或者 i == x / i
				return i;
		}
		
		return i - 1;
	}
	
	/**
	 * 方法二：二分查找效率更高
	 * 二分查找,时间复杂度O(logn)
	 * @param x
	 * @return
	 */
	public static int sqrt_1(int x){
		boolean flag = false;//标记是否是异常输入
		if(x < 0){
			flag = true;
			return -1;
		}
		
		if(x == 0)
			return 0;
		if(x == 1)
			return 1;
		
		//初始low与high，high初始化为  x/2
		int low = 1,high = x / 2;
		int mid = low + (high - low) / 2; //防止出现越界，用这种方式来替代 (low + high) /2
		while(low <= high){
			if(mid == x / mid){//这里也是防止越界进行的处理
				return mid;
			} 
			else if(mid > x / mid)
				high = mid - 1;
			else {
				low = mid + 1;
			}
			mid = low + (high - low) / 2; //防止出现越界，用这种方式来替代 (low + high) /2
		}
		
		//跳出循环，总是 low = high + 1，high是小值，因此返回high
		return high;
	}
}
