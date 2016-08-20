package combination_permutation_subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个字符串，输出该字符串的全排列
 * 其中字符串中没有重复字符
 * 若是存在重复字符，则在求出的结果中，将相同的字符串排除即可
 * @author Administrator
 */
public class Permutation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.next();
	        System.out.println(permutation(s).size());
	        System.out.println(permutation(s));
		}
    }
    
	/**
     * 输入一个字符串，输出该字符串的全排列
     * @param str
     */
    public static List<String> permutation(String str){
    	List<String> list = new ArrayList<String>();
    	if(str == null || str.length() == 0)
    		return list;
    	
    	char[] charArray = str.toCharArray();
    	permutation(charArray,0,list);
    	return list;
    }
    
    /**
	 * 输出一个字符串的全排列
	 * @param orginal
	 * @return
	 */
    private static void permutation(char[] array,int begin,List<String> list){
    	if(begin < 0 || begin >= array.length)
    		list.add(getStr(array));
		    //获得一个字符串
    	else {
			for(int i = begin;i < array.length;i++){
				char tmp = array[i];
				array[i] = array[begin];
				array[begin] = tmp;
				
				//递归
				permutation(array, begin + 1,list);
				
				//还原回去
				char tmp1 = array[i];
				array[i] = array[begin];
				array[begin] = tmp1;
			}
		}	
    }
    
    //将一个字符数组转换为字符串
    public static String getStr(char[] array){
    	StringBuilder tmp = new StringBuilder();
    	for(int i = 0; i < array.length; i++)
    		tmp.append(array[i]);
    	return tmp.toString();
    }
}
