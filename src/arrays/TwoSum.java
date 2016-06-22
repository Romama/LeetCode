package arrays;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,5,7,9};
		int[] res = two(nums, 9);
		for(int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
	
	}
	
	/**
	 * 返回nums中和为target的两个数的下标数组
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] two(int[] nums, int target) {
        if(nums == null)
        	return null;
        int[] result = new int[2];
        if(nums.length == 0)
        	return result;
        for(int i = 1; i < nums.length;i++)
        	for(int j = 0; j < i;j++){
        		if(nums[i] + nums[j] == target){
        			result[0] = j;
        			result[1] = i;
        			return result;
        		}
        	}
        return result;
    }
}
