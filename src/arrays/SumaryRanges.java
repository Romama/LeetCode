package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
   For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author admin
 * 给定一个排好序的数组，对这个数组中连续的子数组用变化范围表示，返回所有范围结果。
 */
public class SumaryRanges {

	public static void main(String[] args){
		int[] nums = {1,2,3,4,6,7,8,10,11,13,15,16};
		System.out.println(changes(nums));
	}
	
	//返回范围
	public static List<String> changes(int[] nums){
		//当nums为空时，应该返回[]
		List<String> list = new ArrayList<String>();
		if(nums == null || nums.length == 0) //对于这种类型的返回值，都是预先设定一个list，然后判断后直接返回list，而不是单独返回null
			return list;
		int begin = nums[0];
		String range = "";
		for(int i = 1; i < nums.length ; i++){
			if(nums[i] - nums[i - 1] == 1)
				continue;
			else {
				if(begin == nums[i - 1]) //若一个数成为一个分段
					range = begin + "";
				else {  //若连续几个数成为一个分段
					range = begin + "->" + nums[i - 1];
				}
				list.add(range); //加入一个分段到list中
				begin = nums[i]; //设定下一个分段的初始值
			}
		}
		//对最后一个范围进行特殊处理
		if(begin == nums[nums.length - 1])
		    range = begin + "";
		else
			range = begin + "->" + nums[nums.length - 1];
		
		list.add(range);
		
		return list;
	}
}
