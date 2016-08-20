package medium;

import java.util.Arrays;

/**
 * 无序数组，和target，找出满足 a+b+c+d = target的所有组合
 * @author i333083
 */
public class ThreeSum_closest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		System.out.println(threeSumClosest(nums,target));
	}
	
	public static int threeSumClosest(int[] nums,int target){
		
		if(nums == null || nums.length < 3)
			return 0;
		int len = nums.length;
		int ref = nums[0] + nums[1] + nums[len - 1];
	    Arrays.sort(nums); //排序
	    int low,high,sum;
	    for(int i = 0; i < len - 2; ++i){
	    	low = i + 1;
	    	high = len - 1;
	    	
	    	while(low < high){
	    		sum = nums[i] + nums[low] + nums[high];
	    		if(sum == target){ //若相等，直接返回结果
	    			return sum; 
	    		} else if(sum < target){
	    			low++;
	    		} else 
	    			high--;
	    		//sum更接近ref
		    	if(Math.abs(ref - target) > Math.abs(sum - target)){
		    		ref = sum;
		    	}
	    	}
	    	
	    }
	    
	    return ref;
	}
}
