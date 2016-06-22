package basics;

import java.util.HashMap;


/**
 * 输入一个罗马数字，返回它的整型表示
 * @author admin
 * 转换规则：从右向左或者从左向右均可
 * 1 相同数字连写，相加 ;2 小数字在大数字右边，相加;3 小数字在大数字左边，大的减去小的
 */
public class RomanToInteger {

	public static void main(String[] args){
		String romanString = "CLIX";
		System.out.println(romanToInt1(romanString));
	}
	
	//第一种方法：采用hashmap，从右向左
	public static int romanToInt(String s){
		HashMap<Character, Integer> roma_weight = new HashMap<Character, Integer>();
		roma_weight.put('I', 1);
		roma_weight.put('V', 5);
		roma_weight.put('X',10);
		roma_weight.put('L', 50);
		roma_weight.put('C', 100);
		roma_weight.put('D',500);
		roma_weight.put('M',1000);
		
		char[] roma = s.toCharArray();  //将罗马数字转化为字符数组
		int length = roma.length;
		int preValue = 0;  //前一步的value
		int value = roma_weight.get(roma[length - 1]) ;// 当前的value
		
		//从右向左遍历
		for(int i = length - 2; i >= 0 ; i--){
			//小的数字在大数字右边，直接相加
			if( roma_weight.get(roma[i]) >= roma_weight.get(roma[i + 1])) {
				preValue = value;
				value = value + roma_weight.get(roma[i]);
			}
			else { //小的数字在大数字左边，大的减去小的
				value = preValue + roma_weight.get(roma[i + 1]) - roma_weight.get(roma[i]);
			}
		}
		return value;
	}
	
	//第二种方法，是在第一种方法的基础上修改的，从左向右
	public static int romanToInt1(String s) {
        char[] ss = s.toCharArray();
        int ret = toNumber(ss[0]);  
        for (int i = 1; i < ss.length; i++) {  
            if (toNumber(ss[i - 1]) < toNumber(ss[i])) {  
            	//ret - toNumber(ss[i - 1]) = preValue; 然后再进行 preValue + toNumber(ss[i]) - toNumber(ss[i - 1]);
                ret += toNumber(ss[i]) - 2 * toNumber(ss[i - 1]);  //相当于  preValue + roma_weight.get(roma[i + 1]) - roma_weight.get(roma[i]);
            } else {  
                ret += toNumber(ss[i]);  
            }  
        }  
        return ret;  
	 }
	 
	 //罗马数字权重表，没有空间复杂度，较hashmap要好一些
	 public static int toNumber(char ch) {  
        switch (ch) {  
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
        }  
	    return 0;  
	 }  
}
