package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个数组，求这个数组的所有组合
 * @author Administrator
 *
 */
public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//定义一个集合
		int[] array = {7,8,9,0};
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int number = 1;
	}
	
	/**
	 * 求一个数组中元素的所有组合。{1,2,3}的所有组合有 1,2,3,12,13,23,123
	 * @param array
	 * @param list
	 * @return
	 */
	public static List<List<Integer>> getAllCombinations(int[] array,List<List<Integer>> list){
		if(array == null || array.length == 0)
			return list;
	
		for(int i = 1,len = array.length; i <= len; ++i){
			getCombinationsOfM(array, i, list);
		}
		
		return list;
	}
	
	/**
	 * 输入一个数组，求数组中所有长度为m的组合
	 * @param array
	 * @return
	 */
	public void getCombinationsOfM(int[] array,int m,List<List<Integer>> list){
		if(m == 0 || array == null || array.length == 0)
			return;
		
		
	}

}
