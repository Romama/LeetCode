package easy;

import java.util.HashMap;

/**
 * 给定一个数组nums，一个目标值target，求这个数组中满足 a+b=target的两个数a和b
 * @author i333083
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,7,9,3,5};
		System.out.println(twoSum(nums,9).length);
	}
	
	//求满足a+b = target的两个数a和b，并返回其下标
	public static int[] twoSum(int[] nums,int target){
		if(nums == null || nums.length < 2)
			return new int[0];
		//设计巧妙之处，将target-nums[i]作为key，i作为value存入到map中
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int len = nums.length;
		for(int i = 0; i < len; ++i){
			map.put(target - nums[i], i);
		}
		//因为HashMap存储的key
		Integer index;
		int[] a = new int[2];
		//查找map中是否存在key为nums[j]的值，若存在，则nums[j] = target - nums[i],若i != j时，找到！
		for(int j = 0; j < len; ++j){
			index = map.get(nums[j]);//查找map中是否存在key为nums[j]的值
			if(index != null && index != j){
				a[0] = j;
				a[1] = index;
				return a;
			}
		}
		
		return new int[0];
	}

}
