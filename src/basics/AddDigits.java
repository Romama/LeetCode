package basics;

/**
 * 非负整数的各位相加，直到相加结果为一位数
 * @author admin
 *
 */
public class AddDigits {

	public static void main(String[] args){
		
		System.out.println(addDigits(388));
		System.out.println(addDigits_1(388));
		System.out.println(addDigits_2(388));
	}
	
	/**
	 * 方法一
	 * 找出的规律
	 * 123456789 10 11 12 13
	 * 123456789 1  2  3  4
	 * @param num
	 * @return
	 */
	public static int addDigits(int num){
		return 1 + (num - 1) % 9; 
	}
	
	/**
	 * 方法二
	 * 递归查找
	 */
	public static int addDigits_1(int num){
		while(num >= 10){
			num = num / 10 + num % 10;
		}
		return num;
	}
	/**
	 * 方法三
	 * 递归查找
	 */
	public static int addDigits_2(int num){
		int newNum = returnNum(num);
		while(newNum >= 10)
	           newNum = returnNum(newNum);
	         return newNum;
	}
	public static int returnNum(int num){
	        int sum = 0;
	        while(num != 0){
	            sum = sum + num % 10;
	            num = num /10;
	        }
	        return sum;
	} 
	
}