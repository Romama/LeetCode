package easy;
/**
 * 将一个整数reverse
 * @author i333083
 *
 */
public class ReverseInt {

	public static void main(String[] args){
		System.out.println(reverseInt(-1235));
		
	}
	
    public static int reverseInt(int x){
    	int ret = 0;
        int digit = 0;
        boolean neg_flag = false;
    
        if (x < 0) {
            neg_flag = true;
            x = -1 * x;  //covert to abs(x), and record the symbol of negative or positive. 
        }
            
        while (x != 0) {
            digit = x % 10; //get the last digit of x，获得x的最末尾数字
            
            //if ret overflows?
            if (ret != 0) { 
                if ((Integer.MAX_VALUE - digit) / ret < 10 ) //这里必须这样判断，否则容易越界。这里ret要作为除数，因此要判断ret != 0
                    return 0;
                    
                if (neg_flag == true) {
                    if (-10 < (Integer.MIN_VALUE + digit) / ret) //这里必须这样判断，否则容易越界。
                    //if we convert the number to abs, we need to compare it in negative form with Integer.MIN_VALUE
                   return 0;
                } 
            }
            
            ret = ret * 10 + digit;
            x = x / 10; //chop off the last digit of x，斩断x的最末尾数字
        }
        
        if (neg_flag == true && ret > 0)
            ret = -1 * ret;
            
        return ret;
    }
}
