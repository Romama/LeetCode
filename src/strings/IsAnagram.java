package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;




/**
 * 判断是否是相同字符异序词
 * @author Administrator
 *
 */
public class IsAnagram {

	public static void main(String[] args){
	
		int[] nums = {3,4,1,3,2,5,6,10};
		int[] nums1 = {3,4,1,3,2,5,6,10};
		System.out.println(nums.equals(nums1));
		System.out.println(containsDuplicate(nums));
		String s = "a";
		String t = "ab";
		System.out.println(anagram(s, t));
		System.out.println(isAna(s, t));
	}
	
	/**
	 * 计数
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean anagram(String s, String t){
		
		int[] count = new int[26];
		for(int i = 0; i < s.length();i++)
			count[s.charAt(i)-'a']++;
		for(int i = 0; i < t.length(); i++)
			count[t.charAt(i)-'a']--;
		for(int i = 0; i < count.length;i++)
			if(count[i] != 0)
				return false;
		return true;
	}
	
	/**
	 * hashtable
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAna(String s,String t){
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else 
				map.put(c, 1);
		}
		
		for(int i = 0; i < t.length();i++){
			char c = t.charAt(i);
			if(map.containsKey(c))
				map.put(c, map.get(c) - 1);
			else 
				return false;
		}
		
		Iterator<Map.Entry<Character, Integer>> entries = map.entrySet().iterator();  
		  
		while (entries.hasNext()) {  
		    Map.Entry<Character, Integer> entry = entries.next();  
		    if(entry.getValue() != 0)
		    	return false;
		}  
		return true;
	}
	
	 //数组中是否存在重复元素
	 public static boolean containsDuplicate(int[] nums) {
		    Stack<Integer> s = new Stack<Integer>();
		    Queue<Integer> queue = new LinkedList<Integer>();
		    List<Integer> list = new ArrayList<Integer>();
		    List<Integer> list2 = new ArrayList<Integer>();
		    Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		    map1.put(1, 1);
		    map1.put(2, 2);
		    map1.put(3, 3);
		    map1.containsKey(1);
		    map1.containsValue(2);
		    map1.size();
		    map1.remove(3);
		    
		    
		    list2.add(34);
		    list2.add(22);
		    list2.add(56);
		    
		    s.push(2);
		    s.push(4);
		    s.pop();
		    s.peek();
		    
		    queue.add(34);
		    queue.peek();
		    queue.poll();
		    
		    list.add(25);
		    list.add(12);
		    list.add(45);
		    list.addAll(1,list2); //将list2添加到list中去
		    list.get(5); //get(index);
		    list.remove(1); //remove(index);
		    
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i =0; i < nums.length; i++){
	            if(map.containsKey(nums[i]))
	               return true;
	            map.put(nums[i],nums[i]);
	        }
	        return false;
	 }
}