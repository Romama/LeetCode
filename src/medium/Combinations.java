package medium;

import java.util.ArrayList;
import java.util.Arrays;
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
		int[] array = {1,2,2};
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
		    Arrays.sort(array);
		    List<List<Integer>> list = new ArrayList<List<Integer>>();
		    List<Integer> item = new ArrayList<Integer>();
		    dfs_repeated(list, item, 0, array);
		    //dfs(array, 0, each, res);
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
    	if(item.size() > 0){
    		List<Integer> t = new ArrayList<Integer>(item);
            list.add(t);
    	}
    	
        for(int i = start,n = array.length;i < n;i++){
            item.add(array[i]);
            dfs(array,i + 1,item,list);
            item.remove(item.size() - 1);//这里list的删除，只能根据下标index值删除元素，无法根据元素值删除
        }
    }
    
    /**
     * 情景二：存在重复元素，解决方法参考subsetsII
     * 求子集的算法同求重复元素的算法原理是相同的！
     * 首先对数组元素进行排序
     * {1,2,2}的所有组合有 1,2,12,122
     */
    public static void dfs_repeated(List<List<Integer>> list, List<Integer> item, int start, int[] array){
  
    	if(item.size() > 0)
            list.add(new ArrayList<Integer>(item));
    	int i = start;
    	while(i < array.length){
    		item.add(array[i]);
    		dfs_repeated(list, item, i + 1, array);
    		item.remove(item.size() - 1);
    		i++;
    		//排除重复的元素，直到找到一个不重复的元素时再添加
    		while(i < array.length && array[i] == array[i - 1])
    			i++;
    	}
    }
}
