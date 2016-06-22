package arrays;

import java.util.HashMap;
import java.util.Map;


/**
 * 从给定的一组只包含小写字母的数组中，删除重复字符，使每个字符出现且仅出现一次。
 * 并且，使得最后留下的字符数组是所有可能的情况中最小的一个
 * 例如：bcabc，结果应该为abc
 * @author Administrator
 *   思路一：
 * 这道题如果用Java解题的话可以使用一种递归的方法。
 * 先用哈希表记录每个字母出现的次数，再遍历给定字符串s，找出最小的字母，每比较一个字母，在哈希表中的值减1，如果此时为0了，
 * 则不继续遍历了，此时我们记录了一个位置，把字符串s中该位置左边的字符都删掉，右边的所有再出现的该字母也删掉，递归调用此函数即可，
 * 在Java中可以使用replaceAll函数。
 *   思路二：
 * 这道题让我们移除重复字母，使得每个字符只能出现一次，而且结果要按字母顺序排，前提是不能打乱其原本的相对位置。
 * 我们的解题思路是：先建立一个哈希表来统计每个字母出现的次数，还需要一个visited数字来纪录每个字母是否被访问过，我们遍历整个字符串，
 * 对于遍历到的字符，先在哈希表中将其值减一，然后看visited中是否被访问过，若访问过则继续循环，说明该字母已经出现在结果中并且位置已经安排妥当。
 * 如果没访问过，我们和结果中最后一个字母比较，如果该字母的ASCII码小并且结果中的最后一个字母在哈希表中的值不为0(说明后面还会出现这个字母)，
 * 那么我们此时就要在结果中删去最后一个字母且将其标记为未访问，然后加上当前遍历到的字母，并且将其标记为已访问，以此类推直至遍历完整个字符串s，
 * 此时结果里的字符串即为所求。这里有个小技巧，我们一开始给结果字符串res中放个"0"，就是为了在第一次比较时方便，如果为空就没法和res中的最后一个字符比较了，
 * 而'0'的ASCII码要小于任意一个字母的，所以不会有问题。最后我们返回结果时再去掉开头那个'0'即可。 
 */
public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm";
		String s = "cbacdcbc";
		System.out.println(removeDuplicate(s1));
		System.out.println(removeDuplicate_Recursively(s));
	}
	
	/**
	 * 方法一
	 * 递归
	 * 求解res
	 * @param s
	 * @return
	 */
	public static String removeDuplicate_Recursively(String s){
		if(s == null)
			return null;
		int len = s.length();  
        if(len == 0) return "";  
        
        /**存储字符及个数*/  
        Map<Character,Integer> map = new HashMap<Character,Integer>();  
        for(int i = 0;i < len;i++){  
            char c = s.charAt(i);  
            if(map.containsKey(c)){  
                map.put(c, map.get(c) + 1);  
            } else {  
                map.put(c, 1);  
            }     
        }  
        
          //递归
        
		  /**记录最小字符及位置*/  
	      char ch = s.charAt(0);  
	      int pos = 0;  
	      for(int i = 0;i < len;i++){  //遍历字符串s
	          char c = s.charAt(i);  
	          /**更新最小字符*/  
	          if(c < ch) {   
	              ch = c;  
	              pos = i;  
	          }  
	          /**只有一个字符，不能再减了。更新字符串，递归查找*/  
	          if(map.get(c) == 1) {         
	              s = s.substring(pos + 1).replaceAll(ch + "", "");  
	              return ch + removeDuplicate_Recursively(s);   //递归查找
	          }  else {  
	              map.put(c, map.get(c) - 1);  
	          }    
	      }
	      
	      return "";
	}

	/**
	 * 方法二
	 * 从字符串中删除重复字符
	 * @param s
	 */
	public static String removeDuplicate(String s){
		    if(s == null)
				return null;
			else if (s.trim() == "") {
				return "";
			}
			String res = "0"; //存储结果
			Map<Character,Integer> map = new HashMap<Character, Integer>(); //记录各个字符出现的次数
			boolean[] visited = new boolean[256]; //记录字符是否已经被访问过
			//初始化map
			for (int i = 0; i < s.length(); i++) {
				char key = s.charAt(i);
				if(map.containsKey(key)){//若字符key已经存在，次数加1
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}	
			}
			
			//遍历字符串s
			for(int i = 0; i < s.length(); i++){
				char key = s.charAt(i);
				map.put(key, map.get(key) - 1); //key的次数减1
				if(!visited[key]){ //若key尚未被访问过
					for (int j = res.length() - 1; j >= 1; j--) { //遍历当前结果集中的每一个字符
						char c = res.charAt(j); //取出当前结果中的最后一个字符
						if(key < c && map.get(c) > 0){ //若当前遍历到的字符比res末尾字符小，且末尾字符在后面还会遍历到，则用key替换掉末尾的字符c，并将c设置为尚未访问过
							visited[c] = false;
							res = res.substring(0,res.length() - 1); //删除res中的最后一个字符
						} else if(key > c){
							break;
						} else if(key < c && map.get(c) == 0){ //当前元素比c小，但是c在后面已经不会被遍历到了
							break;
						}
					}
					visited[key] = true;  //设置为已经被访问
					res = res + key;
			   } 
			}
			return res.substring(1);
	}
}
