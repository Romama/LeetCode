package medium;

/**
 * 给定一个数组nums，只有一个数仅出现一次，其余所有数都是出现3次
 * 求仅出现一次的数single
 * @author admin
 * 采用位运算
 */
public class SingleNumber2 {

	public static void main(String[] args){
		int[] nums = {3,4,3,2,2,4,5,2,4,5,7,5,7,9,7,3}; //只有9出现一次，其它的都是出现3次
		System.out.println(singleNumber(nums));
		System.out.println(singleNumber_(nums));
	}
	
	//由于所有数字都是出现奇数次，无法使用hashtable
	//仍然采用位运算，并不是简单的异或等操作，因为所有的数字都是出现 奇数次 
	public static int singleNumber(int[] nums){
		 int[] count = new int[32];//所有数字都使用32位二进制表示，初始为0
	     int result = 0; //singlenumber
	     for(int i = 0; i < 32; i++){
	          for(int j = 0; j < nums.length; j++){
	        	  int key = (nums[j] >> i) & 1;	      
	        	  if (key == 1) { //右移，获得第i个bit，统计1的个数
	                  count[i] ++ ;
	              }
	          }
	          result |= ((count[i] % 3) << i); //第i位左移，然后将所有位相或，最终得到singlenumber
	     }
	     return result;
	 }
	
	//采用掩码，改进上面算法
	public static int singleNumber_(int[] nums){

	      int ones = 0, twos = 0, threes = 0;

	      for(int i = 0; i < nums.length; i++){

	            twos = twos | ( ones & nums[i]);

	            ones = ones ^ nums[i];

	            threes = ones & twos;

	            ones = ones & ~threes;

	            twos = twos & ~threes;
	      }
	      return ones;
	}
}
