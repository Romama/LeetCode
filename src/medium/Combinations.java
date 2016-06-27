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
		int[] array = {7,8,9,7};
		System.out.println(getAllCombinations(array));
	}
	
	/**
	 * 情景一：不存在重复元素
	 * 求一个数组中元素的所有组合。{1,2,3}的所有组合有 1,2,3,12,13,23,123
	 * @param array
	 * @param list
	 * @return
	 */
	public static List<List<Integer>> getAllCombinations(int[] array){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(array == null || array.length == 0)
			return list;
    
        List<Integer> item = new ArrayList<Integer>();
        //dfs(array,0,item,list); //because it need to begin from 1
        dfs_repeated(array, 0, item, list);
        return list;
	}

    /**
     * 情景一：不存在重复元素
     * depth first search, 回溯
     * @param array
     * @param start
     * @param item
     * @param list
     */
    public static void dfs(int[] array,int start,List<Integer> item,List<List<Integer>> list) {
    	if(item.size() != 0){
    		List<Integer> t = new ArrayList<Integer>(item);
            list.add(t);
    	}
    	
        for(int i = start,n = array.length;i < n;i++){
            item.add(array[i]);
            dfs(array,i + 1,item,list);
            item.remove(item.size() - 1);
        }
    }
    
    /**
     * 情景二：存在重复元素
     * {1,2,2}的所有组合有 1,2,12,122
     */
    public static void dfs_repeated(int[] array,int start,List<Integer> item,List<List<Integer>> list){
  
    	if(item.size() != 0){
    		List<Integer> t = new ArrayList<Integer>(item);
            list.add(t);
    	}
    	
        for(int i = start,n = array.length;i < n;i++){
        	boolean flag = false;
        	for(int j = i + 1; j < array.length; j++)
        		if(array[j] == array[i]){
        			flag = true;
        			continue;
        		}
        	if(!flag){
        		item.add(array[i]);
                dfs(array,i + 1,item,list);
                item.remove(item.size() - 1);
        	}
        	
        }
    }
}
