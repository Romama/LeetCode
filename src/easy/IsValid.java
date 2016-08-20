package easy;

import java.util.Stack;

/**
 * 判断括号匹配是否有效
 * @author admin
 *
 */
public class IsValid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "{[(])}";
		System.out.println(isValid(s));
		
	}
	
	 public static boolean isValid(String s) {
	        if(s == null || s.length() == 0)
	          return true;
	        int len = s.length();
	        if(len % 2 != 0) //奇数，一定是false
	          return false;
	        Stack<Character> stack = new Stack<Character>();
	        String pre = "([{";
	        String post = ")]}";
	        for(int i = 0 ; i < len; i++){
	            char c = s.charAt(i); //字符串s的第i+1个字符
	            if(!stack.isEmpty()){//栈非空
	                int pre_index = pre.indexOf(String.valueOf(c));
	                if(pre_index < 0) {//字符在)]}中，出栈，比对
	                    int post_index = post.indexOf(String.valueOf(c));
	                    char x = stack.pop();
	                    int preInx = pre.indexOf(String.valueOf(x));
	                    if(post_index != preInx)
	                      return false;
	                      
	                } else { //字符在([{中，直接入栈
	                    stack.push(c);
	                }
	                
	            } else { //栈为空
	                int post_index = post.indexOf(String.valueOf(c));
	                if(post_index >= 0) //若起始括号在 )]} 中，返回false
	                   return false;
	                else 
	                   stack.push(c); //否则，压入栈中
	            }
	        }
	        if(stack.isEmpty()) //若最终栈为空，说明s有效
	            return true;
	        else
	            return false;
	    }

}
