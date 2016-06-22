package arrays;

/**
 * 给定一个无序数组，存储的有正数、负数，0；
 * 现在查找数组中第一个缺少的正数，
 * 例如  {3,2,0} 返回 1
 * 由于要求时间复杂度为O(n)
 * 考虑“就地交换元素”
 * 将正数元素i对应放在下标为i的位置上
 * @author admin
 *
 */
public class FirstMissingPositive {
	
	public static void main(String[] args){
		int[] nums = {9,7,5,-1,0,6};
		System.out.println(first(nums));
	}
	
	public static int first(int[] nums){
		if(nums == null)
			return -1;
		int n = nums.length;
		if(n < 1) //数组中只有一个数                                                                                                                                   
	        return 1;  
        int pos = 0;  
        while(pos < n){     
        	//交换之后，继续为交换后的元素选择最终位置，直到当前元素不满足交换条件，循环到下一条
            if(nums[pos] > 0 && nums[pos] != pos + 1 && nums[pos] - 1 < n && nums[pos] != nums[nums[pos] - 1]){                                                                                                                                                  
                swap(nums,pos,nums[pos] - 1);     
            }     
            else  
                ++pos;  
        }  
        
        for(int i = 0;i < n; ++i){     
            if(i + 1 != nums[i])  
                return i + 1;                                                                                                                                    
        }     
        return n + 1;  
	}
	
	//交换元素
	public static void swap(int[] nums,int a,int b){     
        int tmp = nums[a];  
        nums[a] = nums[b];  
        nums[b]= tmp;  
	}   
}
