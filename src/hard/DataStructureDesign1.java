package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataStructureDesign1 {

	//设计一个数据结构，使得插入、删除、随机查询一个元素的时间复杂度都是O(1)   
    public static HashMap<Integer,List<Integer>> map; //key、value值分别对应元素和元素的下标，由于允许存储重复的元素，因此value采用list存储

    public static ArrayList<Integer> list; //存储的是元素

    /** Initialize your data structure here. */
    public DataStructureDesign1() {
        map = new HashMap<Integer,List<Integer>>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {//map的key对应的value值是该key值在list中的顺序值
         
        boolean contain = map.containsKey(val);
        if(!contain)
           map.put(val,new ArrayList<Integer>());
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        //每次都删除list中最后一个元素，
        //为了避免移动元素，若待删除元素不是list的最后一个时，将其与list最后一个元素交换。
        boolean contain = map.containsKey(val);
	    if (!contain) return false;
	    int loc = map.get(val).remove( map.get(val).size() - 1 );
	    if (loc < list.size() - 1 ) {
	       int lastone = list.get(list.size() - 1);
	       list.set( loc , lastone );
	       map.get(lastone).remove( map.get(lastone).size() - 1);
	       map.get(lastone).add(loc);
	    }
	    list.remove( list.size() - 1 );
	    if (map.get(val).isEmpty()) 
	    	map.remove(val);
	    return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() { //随机生成下标，返回元素
        int random = (int)(Math.random() * list.size());
        return list.get(random);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.remove(list.size() - 1);
		System.out.println(list + " ; " + list.size());
	}

}
