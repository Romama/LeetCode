package easy;

/**
 * 判断一个数是不是丑数
 * @author Administrator
 *
 */
public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 8;
		System.out.println(isUglyNumber(n));
	}
	
	//判断一个正整数是不是丑数，将2，3，5 因子都除掉，看最后是否剩下1，若还有其他质因子，返回false
	public static boolean isUglyNumber(int n){
		if(n <= 0)
			return false;
		while(n % 2 == 0)
			n = n >> 1; //位运算的效率要高于算术运算
		while(n % 3 == 0)
			n = n / 3;
		while(n % 5 == 0)
			n = n / 5;
		if(n == 1)
			return true;
		else 
			return false;
	}

}
