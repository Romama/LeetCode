package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 求数组中一系列数的所有排列
 * @author WeiCuicui
 *
 */
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//定义数组
		int[] array = {1,2,3};
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int start = 0;
		
		//不去重
		list = getPermutations(array, list, start);
		
		System.out.println(list);
		
		//去重
		list = getAllPermutations(array, new ArrayList<List<Integer>>(), start);
		
		System.out.println(list);
	}
	
	/**
	 * 第一种：不考虑有重复字符
	 * @param array
	 * @return
	 */
	public static List<List<Integer>> getPermutations(int[] array,List<List<Integer>> list,int start){
		if(start == array.length){//遍历到最后一个
			List<Integer> item = new ArrayList<Integer>(array.length);
			for(int i = 0,len = array.length; i < len; ++i)
				item.add(array[i]);
			list.add(item);
		} else {
			for(int i = start,len = array.length; i < len; ++i){ //第一个元素，依次与后面的所有元素进行交换
				//交换
				int tmp = array[i];
				array[i] = array[start];
				array[start] = tmp;
				
				//递归在循环里
				getPermutations(array,list,start + 1); //字符串分为两部分，第一个元素及第一个元素之后的所有元素
				
				//回溯
				tmp = array[start];
				array[start] = array[i];
				array[i] = tmp;
				
			}
		}
		
		return list;
	}
	
	/**
	 * 第二种：考虑有重复字符
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
			
		else {
			for(int i = start,len = array.length; i < len; ++i){
				boolean flag = false;
				for(int j = start; j < i; ++j)
					if(array[j] == array[i])//若存在重复数字，则不交换
						flag = true;
				if(!flag){
					//交换
					int tmp = array[i];
					array[i] = array[start];
					array[start] = tmp;
					
					//递归在循环里
					getPermutations(array,list,start + 1);
					
					
					//回溯
					tmp = array[start];
					array[start] = array[i];
					array[i] = tmp;
				}
			}
		}
		
		return list;
			
	}

}
