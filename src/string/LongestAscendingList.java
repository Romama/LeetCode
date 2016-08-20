package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 最长递增子序列
 * @author Administrator
 *
 */
public class LongestAscendingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] nums = {5,3,2,4,9,0};
		
		Scanner in = new Scanner(System.in);
		int tmp = 0;
		List<Integer> list = new ArrayList<Integer>();
		while(in.hasNext()){
			try{
				tmp = in.nextInt();
				list.add(tmp);
			} catch(Exception e) {  //非法输入判断
				System.out.println("error");
			}
		}
		in.close();
		int[] nums = new int[list.size()];
		for(int i = 0; i < list.size(); i++){
			nums[i] = list.get(i);
		}
		getLongestSubList(nums);
		
	}
	
	public static int[] getLongestSubList(int[] nums){
		if(nums == null || nums.length == 0)
			System.out.println("error"); 
		int len = nums.length;
		int[] dp = new int[len]; //存储第i个元素之前最长的子序列长度
		List<Integer> subList = new ArrayList<Integer>(); //存储第i个元素之前最长的子序列
		quickSort(nums, 0, len - 1);
		dp[0] = 1;
		subList.add(nums[0]);
		for(int i = 1; i < len; i++){
			dp[i] = 1; //初始为1
			for(int j = 0; j < i; j++){
				if(nums[j] < nums[i] && (dp[j] + 1) > dp[i]){
					dp[i] = dp[j] + 1;
					if (!subList.contains(nums[i])){
                        subList.add(nums[i]);
                    }
					
				} else {
					dp[i] = dp[j];
					subList = new ArrayList<Integer>();
				}
			}
		}
	
		System.out.println(subList);
		int[] array = new int[subList.size()];
		int k = 0;
		while(k < subList.size()){
			array[k] = subList.get(k);
			k++;
		}
		
		int max = 0;
		for(int i = 0;i < len; i++){
			if(dp[i] > max)
			max = dp[i];
		}
		return array;
	}
	
	//快速排序（不稳定）
	public static void quickSort(int[] nums,int left,int right){
        
        if(left < right){
        	//划分位置
        	int dp = partition(nums, left, right); //最终位置 dp
        	quickSort(nums, left, dp - 1); //dp - 1
        	quickSort(nums, dp + 1, right); //dp + 1
        }
	}
	//快速排序之划分
	public static int partition(int[] nums,int left,int right){
		int pivot = nums[left];
		while(left < right){
			while(left < right && nums[right] >= pivot)//从右到左
				right--;
			nums[left] = nums[right];
			while(left < right && nums[left] < pivot)//从左到右
				left++;
			nums[right] =nums[left];
		}
		nums[left] = pivot;
		return left;
	}
}
