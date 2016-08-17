package medium;
import java.util.List;
import java.util.ArrayList;
/**
 * 给定n和k，求[1,...,n]的第k个排列
 * @author i333083
 */
public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{2,5,6,7};
		int k = 4;
		System.out.println(kthPermutation(nums,k));
	}
	
	public static List<Integer> kthPermutation(int[] nums,int k){
		if(nums == null || nums.length == 0)
			return null;
		if(nums.length == 1)
			return new ArrayList<Integer>(nums[0]);
		if( k == 1){
			List<Integer> item = new ArrayList<Integer>();
			for(int i = 0; i < nums.length; ++i)
				item.add(nums[i]);
	        return item;
		}
		for(int i = 1; i <= k - 2; ++i){
			nextPermutation(nums);
		}
		return nextPermutation(nums);
	}
	
	/**
	 * 获取下一个字典序的排列
	 * @return
	 */
	public static List<Integer> nextPermutation(int[] nums){
		if(nums == null)
			return null;
		if(nums.length == 0)
			return new ArrayList<Integer>();
		//长度为1的数组
		if (nums.length == 1) {
			return new ArrayList<Integer>(nums[0]);
		}
		//存储结果
		List<Integer> result = new ArrayList<Integer>();
		
		//从后向前找到第一个不满足逆序的元素
		int i = nums.length - 2; 
		for(; i >= 0 && nums[i] >= nums[i + 1]; --i); //注意，这里有=，可以排除含有重复元素的情况
		
		//从i+1位置开始，向后查找比nums[i]大的最小元素
		if(i >= 0){ 
			int j = i + 1;
			for(; j < nums.length && nums[j] > nums[i]; ++j);
			swap(nums,i,j - 1); //交换，注意是同 j - 1交换
		}
		
		//将i之后的元素逆置(这里包含一种特殊情况，若该排列已经是字典序中的最大了，则下一个序列应该是最小字典序，因此，直接在这里逆置即可)
		int k = nums.length - 1;
		i++;
		for(; i < k; i++, k--)
            swap(nums, i, k);
		
		for(int l = 0,len = nums.length; l < len; ++l)
			result.add(nums[l]);
		
		return result;
	}
    
	/**
	 * 交换元素
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(int[] array,int i ,int j){
		//交换
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
