package medium;

/**
 * perfect squares，完全平方
 * 求一个数的完全平方根
 * 如 1，4，9,16...
 * 同 sqrt中的两种方法
 * @author Administrator
 *
 */
public class ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 方法一：
	 * 平方根遍历法
	 * @param num
	 * @return
	 */
	public static boolean isPerfectSquare(int num) {
        if(num < 0)
            return false;
        for(int i = 1; i <= num / i; ++i){
        	//这里必须是  i * i
            if(i * i == num)
              return true;
        }
        return false;
    }
	
	/**
	 * 方法二：
	 * 二分法
	 * @param num
	 * @return
	 */
	public static boolean isPerfectSquare_1(int num) {
		if(num < 0)
            return false;
        if(num == 1)
            return true;
        //必须使用long类型，否则可能会越界
        long low = 1,high = num / 2;
        long mid = low + (high - low) / 2;
        while(low <= high){
        	if(mid * mid == num){ //可能越界，因此声明类型是long
        		return true;
        	}
        	else if(mid * mid < num)
        		low = mid + 1;
        	else {
				high = mid - 1;
			}
			mid = low + (high - low) / 2;
        }
        return false;
    }

}
