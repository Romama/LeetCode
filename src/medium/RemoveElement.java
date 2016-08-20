package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组和一个value，删除数组中所有值为value的元素
 * @author admin
 *
 */
public class RemoveElement {

	public static void main(String[] args){
		int[] nums = {4,5};
		int len = removeElement1(nums, 4);
		System.out.println(len);
		for(int i = 0;i < len; i++)
			System.out.print(nums[i] + " ");
	}
	
	//方法一：借助于list存储，空间复杂度为O(n)
	public static int removeElement(int nums[],int val){

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != val)
				list.add(nums[i]);
		}
		
		if(list.size() != 0){
			for (int i = 0; i < list.size(); i++) {
				nums[i] = list.get(i);
			}
		}
		
		return list.size() ;
	}
	
	//方法二：two pointers，两个指针，对数组做原地修改，不需要借助额外的空间
	public static int removeElement1(int[] nums,int val){
		int newindex = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != val)
				nums[newindex++] = nums[i];
		}
		
		return newindex;
	}
}
