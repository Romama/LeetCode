package medium;

/**
 * pow(x,n)
 * @author Administrator
 *
 */
public class PowBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double myPow(double x, int n) {
        if(equal(x, 0.0) && n <= 0)
			return 0.0;
		int exponent = n;
		
		//当n取最小整数值时，若取绝对值，则会越界，所以进行特殊处理
		if(n == Integer.MIN_VALUE){
			return myPow(1.0 / x, Integer.MAX_VALUE) * (1.0 / x);
		}
		if(exponent < 0)
			exponent = -exponent;
		double result = getPow(x, exponent);
		if(n < 0)
			return 1.0 / result;
		return result;
    }
    //自定义函数，判断两个double类型的数是否相等
	public static boolean equal(double a,double b){
		if(a - b >= -0.00000001 && a - b <= 0.00000001)
			return true;
		else 
			return false;
	}
	
	/**
	 * 二分查找，时间复杂度O(logn)
	 * @param absBase
	 * @param n
	 * @return
	 */
	public static double getPow(double base,int exponent){
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		double pow = getPow(base, exponent >> 1);
		pow = pow * pow;
		//逻辑与运算。0x开头表示16进制，0开头表示8进制。
		if((exponent & 0x1) == 1){
			pow = pow * base;
		}
		return pow;
	}

}
