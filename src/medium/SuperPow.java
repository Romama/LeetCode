package medium;

/**
 * 利用运算式：  (a^2) % num = (a % num) * (a % num) 
 * @author Administrator
 *
 */
public class SuperPow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Math.pow(1337, 10));
	}
	
	private static final int NUM = 1337;
	
	/**
	 * 求a^b % 1337，1337 = 7 * 191
	 * @param a
	 * @param b
	 * @return
	 */
	public int superPow(int a, int[] b){
	    int ans = 1;
	    //not expecting to be a part of input
	    if(b == null || b.length == 0)
	        return 0;
	    a = a % NUM;
	    int len = b.length;
	    for(int i = 0; i < len; i++){
	        ans = ((pow(ans,10) * pow(a,b[i])) % NUM);
	    }
	    return ans;
	}

	/**
	 * 求a的b次方，递归
	 * @param a
	 * @param b
	 * @return
	 */
	private int pow(int a, int b){
		if(b == 0)
	        return 1;
	    if(b == 1)
	        return a;
	    int x = pow(a,b >> 1); //位运算
	    x = (x * x) % NUM; //这里也要取模运算
	    if((b & 1) == 1)
	        x = (x * a) % NUM; //取模
	    return x;
	}
}
