package medium;

/**
 * 实现x的n次方
 * @author Administrator
 *
 */
public class PowFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double x = 0;
		int n = 0;
		System.out.println(getPow(x, n));
	}
	
	public static double getPow(double x,int n){
		return Math.pow(x, n);
	}

}
