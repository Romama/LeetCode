package medium;

/**
 * 给定一个整型数组，数组中一个或连续的多个整数组成一个子数组，求所有子数组和的最大值。
 * 并输出子数组
 * @author Administrator
 *
 */
public class FindGreatestSumOfSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,-2,3,10,-4,7,2,-5};
		System.out.println("\n" + getMaxSumOfSubArray(nums));
	}
	
	/**
	 * 求数组中所有子数组和的最大值
	 * @param nums
	 * @return
	 */
	public static int getMaxSumOfSubArray(int[] nums){
		boolean invalidInput = false;
		if(nums == null || nums.length == 0){
			invalidInput = true;
			return 0;
		}
		int max = Integer.MIN_VALUE; //最大值初始化为 MIN_VALUE
		int curSum = 0;
		int low = 0,high = 0; //用于记录子数组的起始、终止下标
		for(int i = 0; i < nums.length; i++){
			if(curSum <= 0) {//之前累加的和是个负数，当前值加上负数比它本身还小，所以舍弃
				curSum = nums[i];
				low = i;
			}				
			else if(curSum > 0)
				curSum += nums[i];
			if(max < curSum){
				max = curSum;
				high = i;
			}
		}
		
		for(int i = low;i <= high; i++)
			System.out.print(nums[i] + " ");
		
		return max;
	}
}
