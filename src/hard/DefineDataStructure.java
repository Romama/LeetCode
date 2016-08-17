package hard;

import java.util.HashMap;
import java.util.ArrayList;
public class DefineDataStructure {

	//设计一个数据结构，使得插入、删除、随机查询一个元素的时间复杂度都是O(1)
	   
    public static HashMap<Integer,Integer> map; //key、value值分别对应元素和元素的下标
    
    public static ArrayList<Integer> list; //存储的是元素

    /** Initialize your data structure here. */
    public DefineDataStructure() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {//map的key对应的value值是该key值在list中的顺序值
        if(map.containsKey(val))
            return false;
        else{
            map.put(val,list.size());
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        //每次都删除list中最后一个元素，
        //为了避免移动元素，若待删除元素不是list的最后一个时，将其与list最后一个元素交换。
        if(map.containsKey(val)){
            int index = map.get(val); //待删除元素位置
            int lastIndex = list.size() - 1;//最后一个元素位置
            if(index < lastIndex){ //若交换的不是最后一个元素，进行交换
                //交换元素
                list.set(index,list.get(lastIndex)); 
                //修改元素位置
                map.put(list.get(lastIndex),index);
            }
            list.remove(lastIndex); //list，通过下标remove元素，时间复杂度为O(1)
            map.remove(val);
            return true;
        } else 
            return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() { //随机生成下标，返回元素
        int random = (int)(Math.random() * list.size());
        return list.get(random);
    }
    
    public static void main(String[] args){
    	DefineDataStructure dd = new DefineDataStructure();
    	
    	System.out.println(dd.insert(1));
    	System.out.println(dd.remove(2));
    	System.out.println(dd.insert(2));
    	System.out.println(dd.getRandom());
    	System.out.println(dd.remove(1));
    	System.out.println(dd.insert(2));
    	System.out.println(dd.getRandom());
    }

}

