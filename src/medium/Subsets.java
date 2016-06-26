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
		int[] array = {2,3,1,4};
	}
	
	public List<List<Integer>> getSubsets(int[] array){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> item = new ArrayList<Integer>();
		if(array == null || array.length == 0)
			return list;
	}
}
