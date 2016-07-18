package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * HappyNumber
 * Example: 19 is a happy number
	1^2 + 9^2 = 82
	8^2 + 2^2 = 68
	6^2 + 8^2 = 100
	1^2 + 0^2 + 0^2 = 1
 * 正整数
 * @author Administrator
 *
 */
public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//判断一个正整数是不是happynumber
	public static boolean isHappyNumber(int n){
		//将每一步求得的数存储在hashset中，一旦出现非1的重复，说明开始无限循环，则不符合happynumber的要求，因为它永远得不到1
		Set<Integer> set = new HashSet<Integer>(); //set中不允许存在重复元素，在执行add()方法时若放回false，说明添加元素失败
		if(n <= 0)
			return false;
		while(set.add(n)){
			n = sumOfSuqares(n); //求各位平方和
			if(n == 1) //若为1，终止
				return true;
		}
		return false;
	}
	
	//计算一个数的各位平方和
	public static int sumOfSuqares(int n){
		int result = 0;
		while(n != 0){
			result += (n % 10) * (n % 10);
			n = n / 10;
		}
		return result;
	}

}
