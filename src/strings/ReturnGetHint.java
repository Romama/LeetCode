package strings;

/**
 * 给定一个目标字符串secret，猜测它是什么内容，
 * 给出一个猜测字符串guess，判断有哪些是完全对应的，有哪些是位置不对应但是内容对应存在。
 * secret和guess都可能存在重复元素
 * @author admin
 *
 */
public class ReturnGetHint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String secret = "2211".toString();
		String guess = "1122".toString();
		
		System.out.println(getHint(secret, guess));
	}
	
	 public static String getHint(String secret, String guess) {
            String hint = null;
	        if(secret == null && guess == null)
	             return hint;
	       
	        char[] gue = guess.toCharArray();
	        char[] sec = secret.toCharArray();
	        int len = sec.length;
	        int bulls = 0;
	        int cows = 0;
	        
	        //统计bulls的数量
	        for(int i = 0; i < len; i++){
	            char x = gue[i];
	            char c = sec[i];
	            if(x == c) {//对应位置上的元素相等
	            	bulls++;
	            	gue[i] = sec[i] = 'a';//用a代替相同的字符
	            }      
	        } 
	        
	        for(int i = 0; i < len; i++){
	        	char x = gue[i];
		        char c = sec[i];
	            if(x != 'a' && x != c) { //对应位置上的元素不等，在secret全范围内搜索
	                int index = findx(sec, x);
	                if(index > -1 ){
	                   cows++;
	                   gue[i] = 'a';
	                   sec[index] = 'a';
	                }
	            }
	        }
	        
	        hint = bulls + "A" + cows + "B";
	        return hint;
    }
    public static int findx(char[] rec,char x){
		 for(int i= 0;i < rec.length;i++)
			 if(rec[i] == x)
				 return i;
		 return -1;
	}

}
