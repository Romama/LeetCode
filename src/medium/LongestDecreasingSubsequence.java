package medium;
/**
 * 
 * 最长递减子序列
 * 及其长度
 * @author Administrator
 *
 */
public class LongestDecreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,4,7,1,5,6,4,3,10};
		System.out.println("\n" + longestSubsequence(nums));
	}
	
	//求一个数组中最长递减子序列
	public static int longestSubsequence(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];    //i下标之前(包括i)的最长递减子序列的长度
		for(int i = 0; i < nums.length; i++)
			dp[i] = 1;
		int[] back = new int[nums.length];   //用于回溯
		for(int i = 0; i < nums.length; i++)
			back[i] = -1;
		int max_point = 0;
		int max = dp[0];
		for(int i = 1; i < nums.length;i++)
			for(int j = 0; j < i; j++){ //从1开始
				if(nums[j] > nums[i] && dp[j] + 1 > dp[i]){
					 //更新dp[i]
					dp[i] = dp[j] + 1;
					if(dp[i] >= max){ //更新max，注意这里是 >= 
						max = dp[i];
						max_point = i; //最长子序列中，最后一个元素的下标
						back[i] = j;  //记录当前元素之前（不包含当前元素）的最长递减子序列的最后一个元素下标
					}			
		        }
			}
		System.out.println("输出回溯下标");
		for(int i = 0; i < back.length;i++)
			System.out.print(back[i] + " ");
		System.out.println("\n" + "输出i下标前最长递减子序列长度");
		for(int i = 0; i < dp.length;i++)
			System.out.print(dp[i] + " ");
		System.out.println("\n" + "最长递减子序列");
		back(max_point,back,nums);
		
		return max;
		
	}
	
	//回溯法输出最长递减子序列
	public static void back(int pos,int[] back,int[] arr){
		if(back[pos] == -1){
			System.out.print(arr[pos] + " ");
			return;
		} else { // 降序输出
			back(back[pos],back,arr);
			System.out.print(arr[pos] + " ");
		}
	}
}
