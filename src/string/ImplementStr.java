package string;

/**
 * 求s1在s2中第一次出现的下标位置
 * @author Administrator
 *
 */
public class ImplementStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "jkdjkdjk",s2 = "djk";
		System.out.println(strStr(s1, s2));
	}
	
	//利用indexOf函数求得needle在haystack中第一次出现的下标，若求最后一次出现的下标，则使用lastIndexOf()函数即可
	public static int strStr(String haystack,String needle){
		if(haystack == null || needle == null)
			return -1;
		else if (haystack == "" && needle == "") //若两者均为""
		    return 0;
		int index = 0;
		
		index = haystack.indexOf(needle);
		return index;
	}

}
