package medium;

/**
 * 给定array和target，array是有序的，查找是否存在两个数a和b使得 a+b=target，若存在返回a和b的位置int[2],按顺序返回
 * @author i333083
 */
public class TwoSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[]{2,4,7,9,10};
		int target = 19;
		int[] result = twoSum_II(nums,target);
		if(result != null && result.length > 0)
		   System.out.println(result[0] + " " + result[1]);
	}
	
	//相比于two sum，这里的nums是有序的！两个指针
	public static int[] twoSum_II(int[] nums,int target){
		int i = 0, j = nums.length - 1;
		int sum;
		int[] result = new int[2];
		while(i < j){
			sum = nums[i] + nums[j];
			if(sum == target){
				//返回元素位置：从1开始，升序
				result[0] = i + 1;
				result[1] = j + 1;
				return result;
			} else if(sum > target){
				j--;
			} else
				i++;
		}
		//若不存在这样的元素对，则返回空数组
		return new int[0];
	}

}
