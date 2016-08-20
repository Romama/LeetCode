package combination_permutation_subset;

import java.util.ArrayList;
import java.util.List;

/**
 * 求全排列，2种方法
 * @author WeiCuicui
 */
public class Permutations {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//定义数组
		int[] array = {1,2,3};
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int start = 0;
		
		//去重
		list = getAllPermutations(array, new ArrayList<List<Integer>>(), start);
		System.out.println(list);
		
		//去重，字典序
		list = permutations(array,new ArrayList<List<Integer>>());
		System.out.println(list);
	}
	
	/**
	 * 方法一：非字典序
	 * 判断当前要交换的字符在前面是否已经出现过，若已经出现过，则不交换
	 * 
	 * @param array
	 * @return
	 */
	public static List<List<Integer>> getAllPermutations(int[] array,List<List<Integer>> list,int start){
		if(start == array.length){//遍历到最后一个
			
			List<Integer> item = new ArrayList<Integer>(array.length);
			for(int i = 0,len = array.length; i < len; ++i)
				item.add(array[i]);
			list.add(item);
		}
		for(int i = start,len = array.length; i < len; ++i){
			boolean flag = false;
			for(int j = start; j < i; ++j) //i是待交换元素，start到i之间（不包括i），若出现过同i相同的元素，则不再交换
				if(array[j] == array[i])//若存在重复数字，则不交换
					flag = true;
			if(!flag){
				
				swap(array,i,start);
				//递归在循环里
				getAllPermutations(array,list,start + 1);
				
				//回溯
				swap(array,i,start);
			}
		}
		return list;	
	}
	
	/**
	 * 字典序（本身具有去重作用）
	 * @return
	 */
	public static List<List<Integer>> permutations(int[] array,List<List<Integer>> list){
		//将原数组加入结果集
		List<Integer> item = new ArrayList<Integer>();
		for(int j = 0,l = array.length; j < l; ++j)
			item.add(array[j]);
		list.add(item);
		while(!isLastOne(array)){
			list.add(nextPermutation(array));
		}
		return list;
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
	 * 判断数组元素是否逆序，若已经逆序，说明已经是全部排列的最后一个
	 * @param array
	 * @return
	 */
	public static boolean isLastOne(int[] array){
		for(int i = 0; i < array.length - 1; ++i){
			if(array[i] < array[i + 1])
				return false;
		}
		return true;
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
