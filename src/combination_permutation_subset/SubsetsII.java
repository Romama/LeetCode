package combination_permutation_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * @author WeiCuicui
 *
 */
public class SubsetsII {

	public static void main(String[] args){
		int[] nums = {1,3,3,2,2};
		System.out.println(subsetsWithDup(nums));
	}
	
	/**
	 * 含有重复元素集合的所有子集
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        int start = 0;
        if(nums == null || nums.length == 0)
        	return list;
        //对集合中的元素进行从小到大的排序，将相同元素放置在相邻的位置上
        Arrays.sort(nums);
        subsets(nums, start, item, list);
        return list;
    }
    
    //获取集合nums下的所有子集，去重
    public static void subsets(int[] nums,int start,List<Integer> item,List<List<Integer>> list){
    	list.add(new ArrayList<Integer>(item));
    	
    	//用于while循环
    	int i = start;
    	while(i < nums.length){
    		item.add(nums[i]);
    		
    		//注意这里是 i + 1
    		subsets(nums, i + 1, item, list);
    		item.remove(item.size() - 1);
    		
    		//去重，
    		i++;
    		while(i < nums.length && nums[i] == nums[i - 1])
    			i++;
    	}
    }
}
