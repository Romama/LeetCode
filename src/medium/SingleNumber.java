package medium;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 一个数组nums中只有一个数只出现一次，其他的数都是出现两次，求只出现一次的数
 * @author admin
 * 利用hashtable 或者 位操作
 */
public class SingleNumber {

	public static void main(String[] args){
		int[] nums = {1,2,4,5,3,6,2,4,5,3,1};
		System.out.println(singleNumber(nums));
		System.out.println(singleNumber_Bit(nums));
	}
	
	//使用 hashset， nums不为空
	public static int singleNumber(int[] nums){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i =0 ;i < nums.length; i++)
			if(!set.add(nums[i]))
				set.remove(nums[i]);
		Iterator<Integer> iterator = set.iterator();//注明为Integer，否则会报错
		return iterator.next();
	}
	
	//采用位运算
	public static int singleNumber_Bit(int[] nums){
		int single = 0;
		for(int i = 0; i < nums.length; i++)
			single = single ^ nums[i];
		return single;
	}
	
	
}
