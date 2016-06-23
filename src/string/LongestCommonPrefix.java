package string;


/**
 * 给定一个字符串数组，求这个数组中所有字符串最长的公共前缀。
 * 思路：遍历一遍strs，先求出前两个字符串的公共前缀，然后将得到的公共前缀作为新的字符串，与下一个字符串求取公共前缀......
 * 直到遍历到最后一个字符串，此时得到的公共前缀就是所有字符串的公共前缀，结束。
 * @author Administrator
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"123","2","1235","124"};
		System.out.println(longestCommonPrefix(strs));

	}
	
	//求字符串数组中所有字符串的最长公共前缀，没有公共前缀时，返回""
    public static String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0)
			return "";
		if(strs.length == 1)
			return strs[0];
		else if(strs.length == 2)
		    return prefix(strs[0], strs[1]);
		
		int i = 2;
		String common = prefix(strs[0], strs[1]);
		if(common == "")
			return "";
		while(i < strs.length){
			common = prefix(common, strs[i]);
			if(common == "") //若无公共前缀，则返回""
				return "";
			i++;
		}
		
		return common;
    }
    
    //两个字符串的最长公共前缀,没有公共前缀时，返回 ""
	public static String prefix(String s1,String s2){
	    String res = "";
		if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
			return res;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int l1 = c1.length,l2 = c2.length,i = 0;
		while(i < l1 && i < l2 && c1[i] == c2[i])
			i++;
		for(int j = 0; j < i; j++)
			res = res + c1[j];
		
		return res;
		
	}
}
