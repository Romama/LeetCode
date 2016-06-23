package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 双向单射：设置两个hashmap进行比较判断
 * 给定一个模式 ： abba
 * 和一个字符串：dog cat cat dog;
 * 判断模式是否完全一致
 * @author Administrator
 *
 */
public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "111";
		String b = "11";
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('c', 'd');
		map.put('c', 'e');
		char c = 'd';
		

		String pattern = "abba";
		String str = "dog cat cat dog";
		System.out.println(wordPattern(pattern, str));
		
		
	}
	
	 public static boolean wordPattern(String pattern, String str) {
	        if(pattern == null || pattern.length() == 0)
	           return false;
	        if(str == null || str.length() == 0)
	           return false;
	           
	        String[] subStrs = str.split(" ");
	        if(subStrs.length != pattern.length())
	           return false;
	           
	        //双向单射，一对一
	        Map<Character,String> map = new HashMap<Character,String>();
	        Map<String,Character> map1 = new HashMap<String,Character>();
	        
	        for(int i = 0 ; i < pattern.length(); i++){
	            char c = pattern.charAt(i);
	            if(map.containsKey(c)){
	                if(!map.get(c).equals(subStrs[i])){
	                    return false;
	                }
	            }else{
	                map.put(c,subStrs[i]);  
	            }
	        }
	    
	       for(int i = 0 ; i < pattern.length(); i++){
	            char c = pattern.charAt(i);
	            if(map1.containsKey(subStrs[i])){
	                if((Character)map1.get(subStrs[i]) != c){ //字符比较，强制转换为Character类型
	                    return false;
	                }
	            }else{
	                map1.put(subStrs[i],c);  
	            }
	        }
	        
	        return true;
	    }
}
