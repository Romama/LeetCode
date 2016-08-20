package medium;
import java.util.*;

/**
 * 给定一个无序数组，找出所有满足和为0的组合 a,b,c
 * @author i333083
 *
 */
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,0};
		System.out.println(threeSum(nums));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        //存储结果
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3)
             return result;
        int len = nums.length;
        //先对nums进行排序
        Arrays.sort(nums);
        int sum; //2元素相加的和
        int low,high; //定义两个指针
      
        for(int i = 0; i < len - 2; ++i){ // 进行 n - 2 趟的查找，数组至少需要3个数
        	if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){ // 去除nums[i] == nums[i - 1]的情况，因为是重复的情况
        		sum = -nums[i];
                low = i + 1; //避免重复，从i+1开始
                high = len - 1;
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                    	result.add(Arrays.asList(nums[i],nums[low],nums[high])); //添加到结果集，将数组元素转为list
                    	while (low < high && nums[low] == nums[low + 1])
                    		low++;
                        while (low < high && nums[high] == nums[high - 1])
                        	high--;
                        low++; 
                        high--;
                    } else if(nums[low] + nums[high] < sum){
                        low++;
                    } else 
                        high--;
                }
        	}
        }
      
        return result;
	}

}
