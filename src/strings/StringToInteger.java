package strings;

/**
 * atoi 是一种特殊的定义
 * 将一个字符串转换为整数
 * 注意：考虑到各种情况！！！
 * 
 * @author Administrator
 *
 */
public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "  +1";
		System.out.println(myAtoi(str));

	}
	
	public static int myAtoi(String str) {
		if(str == null || str.length() == 0)
        	return 0;
        int len = str.length();
        //找到第一个非空字符，k记录第一个非空字符下标
        int k = 0;
        for(; k < len && str.charAt(k) == ' ';k++); 
        
        //第一个有效字符只能是 - 或者 + 或者 0到9
        char c = str.charAt(k);
        if(c != '-' && c != '+' && (c > '9' || c < '0'))  
        	return 0;
        
        //最后一个有效字符
        int j = len - 1;
        for(int i = k + 1; i < len; i++){  //遍历其余字符，直到被一个非数字字符打断
        	if((str.charAt(i) < '0' || str.charAt(i) > '9')){
        		j = i - 1;
        		break;
        	}	
        }
        
        long result = 0;
        //计算字符串的值
        if(c == '-'){
        	for(int i = k + 1; i <= j; i++){
        		result = result *10 + (str.charAt(i) - '0');
        		if(-result < Integer.MIN_VALUE) 
        			return Integer.MIN_VALUE;
        	}
        } else if(c == '+'){
        	for(int i = k + 1; i <= j; i++){
        		result = result *10 + (str.charAt(i) - '0');
        		if(result > Integer.MAX_VALUE) 
        			return Integer.MAX_VALUE;
        	}
		} else {
		    for(int i = k; i <= j; i++){
        		result = result *10 + (str.charAt(i) - '0');
        		if(result > Integer.MAX_VALUE) 
        			return Integer.MAX_VALUE;
        	}
		}
        int res = (int)result;
        if(c == '-')
        	return -res;
        else {
			return res;
		}
    }
	

}
