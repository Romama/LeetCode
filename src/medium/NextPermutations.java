package medium;


/**
 * 
 * @author Administrator
 *
 */
public class NextPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,2};
		next(nums);
		for (int i = 0,len = nums.length; i < len; ++i) {
			System.out.print(nums[i] + " ");
		}
	}
	
	//根据已知排列，生成下一个排列
	public static void next(int[] nums){
		if(nums == null || nums.length == 0){
			return;
		}
		//长度为1的数组
		if (nums.length == 1) {
			return;
		}
		
		//从后向前遍历，找到第一个不满足降序的元素
		int i = nums.length - 2;
        for(; i >= 0 && nums[i] >= nums[i + 1]; i--);
        
        //若存在这样逆序的元素
        if(i >= 0) {
            int j = i + 1;
            for(; j < nums.length && nums[i] < nums[j]; j++); 
            exchange(nums, i, j - 1);
        }
        
        //将i后的所有的元素逆序排列
        //本地逆序，设置两个指针，分别从头和尾部开始遍历，并进行交换
        i++ ; 
        int k = nums.length - 1;
        for(; i < k; i++, k--)
            exchange(nums, i, k);
	}
	
	//交换元素
	public static void exchange(int[] nums,int i,int j){
		
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
