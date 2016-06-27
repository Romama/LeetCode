package medium;

import java.util.ArrayList;
import java.util.List;


public class CombinationsOfK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {2,3,4,5};
		int k = 2;
		System.out.println(getCombinationsOfM(array, k));
	}
	
	/**
	 * n个元素的集合中所有长度为k的组合
	 * @param array
	 * @return
	 */
	public static List<List<Integer>> getCombinationsOfM(int[] array,int k){
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(array == null || array.length == 0)
			return list;
		int n = array.length;
        if(n < k)
          return list;
        List<Integer> item = new ArrayList<Integer>();
        dfs(array,n,k,0,item,list); //because it need to begin from 1
        return list;
		
	}

    //depth first search, 回溯
    public static void dfs(int[] array,int n,int k,int start,List<Integer> item,List<List<Integer>> list) {
        
        if(item.size() == k){
            //这里必须这样写，新建一个对象new ArrayList<Integer>
            //new ArrayList<Integer>(item),是将Item中的元素放到新建立的对象里
            List<Integer> t = new ArrayList<Integer>(item);
            list.add(t);
        } else {
        	for(int i = start;i < n;i++){
                item.add(array[i]);
                dfs(array,n,k,i + 1,item,list);
                item.remove(item.size() - 1);
            }
        }
    }

}
