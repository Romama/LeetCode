package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//collection接口：set和list的父接口
public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//set集合的存、取
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		
		Iterator<Integer> iterator = set.iterator();
		/*//set集合的迭代器
		
		//遍历set集合中的所有元素
		while(iterator.hasNext()){
			System.out.print(iterator.next());
		}*/
		
		//list集合，向list集合中添加元素
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(5);
		
		set = new HashSet<Integer>(list);
		
		//set集合的迭代器
	    iterator = set.iterator();
		//遍历set集合中的所有元素
		while(iterator.hasNext()){
			System.out.print(iterator.next());
		}
				
		
		//遍历list集合
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
		
		//map集合，向map集合中添加元素
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 10);
		map.put(2, 11);
		map.put(3, 12);
		map.put(4, 13);
		
		//第一种方式遍历map
		Iterator<Map.Entry<Integer, Integer>> iterator2 = map.entrySet().iterator();
		while(iterator2.hasNext()){
			Map.Entry<Integer, Integer> next = iterator2.next();
			System.out.println(next.getKey() + " : " + next.getValue());
		}
		
		Map<Integer,Integer> mm = new HashMap<Integer,Integer>();
		for(Map.Entry<Integer, Integer> entry : mm.entrySet()){
			System.out.println(entry.getKey() + " ; " + entry.getValue());
		}
		
		//第二种方式遍历map，推荐使用这种方式遍历map
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			System.out.print(entry.getKey() + ", " + entry.getValue());
		}
	}

}
