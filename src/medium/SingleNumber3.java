package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一个int[] nums，其中只有两个数字出现一次，其余的都是出现两次，找出仅出现一次的两个数
 * 要求：线性时间复杂度；常量的空间复杂度
 * @author admin
 *
 */
public class SingleNumber3 {

	public static void main(String[] args){
		SingleNumber3 sig = new SingleNumber3();
		int[] nums = new int[]{1,2,3,5,1,3,2,4,6,7,4,6};
		int[] singleNum = new int[2];
		
		//hashmap 求位运算，时间复杂度高
		if(sig.singleNumber(nums) != null){
			singleNum = sig.singleNumber(nums);
			for (int i = 0; i < singleNum.length; i++) {
				System.out.print(singleNum[i] + " ");
			}
		}
		
		System.out.println();
		
		//位运算求single number，时间复杂度为O(1)
		if(sig.singleNumber(nums) != null){
			singleNum = singleNumber_Bit(nums);
			for (int k = 0; k < singleNum.length; k++) {
				System.out.print(singleNum[k] + " ");
			}
		}
		
	}
	
	  //采用hashmap
	 public int[] singleNumber(int[] nums) {
       
		if(nums == null || nums.length == 0)
			return null;
		int[] singleNums = new int[2];
	    int k = 0;
	    //遍历nums，找出仅出现一次的数
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				map.remove(nums[i]);
			} else {
				map.put(nums[i], i);
			}	
		}
		
		//迭代器，iterator遍历map集合
		//方法一：使用iterator
		/*Iterator iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry entry = (Map.Entry )iterator.next();
			singleNums[k] = Integer.parseInt(entry.getKey().toString());
			k++;
		}*/
		
		/*//方法二
		//迭代器，遍历map中key集合
		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			singleNums[k] = Integer.parseInt(iterator.next().toString());
			k++;
		}*/
		
		/*//方法三
		//迭代器，遍历map的values集合，返回仅出现一次的数的下标
		Iterator iterator = map.values().iterator();
		while(iterator.hasNext()){
			singleNums[k] = Integer.parseInt(iterator.next().toString());
			k++;
		}*/
		
		//方法四
		//采用hashset
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length;i++){
			if(!set.add(nums[i])) //添加nums[i]为false，说明存在重复元素
				set.remove(nums[i]);
		}
		Iterator<Integer> iterator = set.iterator();
		int l = 0;
		while(iterator.hasNext()){
			singleNums[l] = iterator.next();
			l++;
		}
		return singleNums;
    }
	 
	 //位运算
	 //参照single number 的方法，将所有数异或运算，得到result为两个single number的异或；
	 //找到result中最低位为1的那一位，是两个single number不同的地方，根据这个bit，可以将nums数组中的数分为A、B两组；
	 //然后分别在A和B中寻找single number即可
	 public static int[] singleNumber_Bit(int[] nums){
		 
		 int result = 0;
		 for(int i = 0; i < nums.length; i++){
			 result = result ^ nums[i];
		 }
		 
		 int[] res = new int[2];
		 //找到result二进制表示中最右侧的1
		 int pos = result & ( ~ (result - 1 )); //统计一个int型整数的二进制表示中有多少个1，可以采用 n = n & (n - 1);来从右到左逐个统计1的个数
		 for(int i = 0 ; i < nums.length; i++){ //将nums分为A B两组来分别求single number
			 if((pos & nums[i]) != 0){
				 res[0] = res[0] ^ nums[i];
			 } else {
				 res[1] = res[1] ^ nums[i];
			}
		 }
		 return res;
	 }
}
