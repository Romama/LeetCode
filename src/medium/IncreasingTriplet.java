package medium;
/**
 * 要求O(n)的时间复杂度和O(1)的空间复杂度
 * 记录两个变量：第一最小值min1和第二最小值min2，这样，若能够遍历到一个值比min1和min2均小，则返回true
 * @author Administrator
 *
 */
public class IncreasingTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,-2,6};
		System.out.println(hasIncreasingTriplet(nums));

	}
	
	public static boolean hasIncreasingTriplet(int[] nums){
		if(nums == null || nums.length <= 2)
			return false;
		int min1 = Integer.MAX_VALUE,min2 = min1; //分别初始化为最大值
		for(int i = 0; i < nums.length; i++){
			if(nums[i] <= min1) //注意：这里是 <=
				min1 = nums[i];
			else if(nums[i] < min2) //这里 < 或者 <= 都可以
				min2 = nums[i];
			else if(nums[i] > min1 && nums[i] > min2)
				return true;
		}
		return false;
	}
}
