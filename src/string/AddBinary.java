package string;

/**
 * 将两个存储在String中的二进制数相加，返回其结果
 * @author Administrator
 *
 */
public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "111";
		String b = "11";
		
		System.out.println(addBinary(a, b));
	}
	
	 public static String addBinary(String a, String b) {
	        if(a == null && b == null) return null;
	        else if(a == null) return b;
	        else if(b == null) return a;
	        int la = a.length(),lb = b.length();
	        int ia = la - 1,ib = lb - 1;
	        int val = 0, add = 0;
	        String result = "";
	        while(ia >= 0 || ib >= 0){
	            val = add;
	            if(ia >= 0){
	                val = val + a.charAt(ia) - '0';
	                ia--;
	            }
	            
	            if(ib >= 0){
	                val = val + b.charAt(ib) - '0';
	                ib--;
	            }
	            
	            add = val / 2;
	            val = val % 2;
	            
	            result = val + result;
	        }
	        
	        if(add != 0)
	            result = 1 + result;
	            
	        return result;
	    }
	 
	

}
