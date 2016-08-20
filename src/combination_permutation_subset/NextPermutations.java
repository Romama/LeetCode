package combination_permutation_subset;


/**
 * 按照字典序，生成下一个排列
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
	
	/**
	 * swap + reverse，交换 & 倒叙，保证按照字典序生成排列
	 * 根据已知排列，生成下一个排列
	 * @param nums
	 */
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
        
        //找到比nums[i]大的最小元素，同nums[i]交换
        if(i >= 0) {
            int j = i + 1;
            for(; j < nums.length && nums[i] < nums[j]; j++); 
            exchange(nums, i, j - 1);
        }
        
        //将i后的所有的元素逆序排列（因为i后的所有元素是降序排列的，因此，将其逆序即可）
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
