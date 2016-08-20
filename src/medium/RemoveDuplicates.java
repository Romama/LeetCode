package medium;


/**
 * remove duplicates from sorted array
 * @author admin
 *
 */
public class RemoveDuplicates {

	public static void main(String[] args){
		int[] nums = {1,1,1,1,2,3,5,5};
		int len = removeDuplicate(nums);
		System.out.println(len);
		
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		
	}

	
	//从一个有序数组中删除重复元素
	//采用two pointers的方法，i与j
	public static int removeDuplicate(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		int len = nums.length;
		int j = 1;
		for(int i = 1; i < len; i++){
			if(nums[i] == nums[i - 1])
				continue;
			else {
				nums[j++] = nums[i];
			}
		}
		
		return j;
	}
}
