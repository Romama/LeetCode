package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 求一个集合的所有子集
 * @author WeiCuicui
 *
 */
public class Subsets {

	public static void main(String[] args){
		
		//给集合赋值
		int[] array = {1,2,3};
		System.out.println(getSubsets(array));
	}
	
	public static List<List<Integer>> getSubsets(int[] array){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> item = new ArrayList<Integer>();
		if(array == null || array.length == 0)
			return list;
		int start = 0;
		subsets(array, list, item, start);
		return list;
	}
	
	//获取所有的子集
	public static void subsets(int[] array,List<List<Integer>> list,List<Integer> item,int start){
		list.add(new ArrayList<Integer>(item));

		for(int i = start,len = array.length; i < len;++i){
			item.add(array[i]);
			subsets(array, list, item, i + 1);
			item.remove(item.size() - 1);
		}
	}
}
