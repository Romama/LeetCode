package easy;

/**
 * 一个整数数组，在末尾加1
 * 返回加1后的结果
 * @author admin
 *
 */
public class PlusOne {

	public static void main(String[] args){
		int[] digits = {9,8,9,9,9,1,9};
		int[] res = plusone(digits);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
	public static int[] plusone(int[] digits){
		if(digits == null || digits.length == 0)
			return null;
		int len = digits.length;
		int carry = 0; //进位
		for(int i = len - 1; i >= 0; i--){
			if(i == len - 1){
				carry = (digits[i] + 1 ) / 10; //进位
				digits[i] = (digits[i] + 1 ) % 10; //本位
			} else {
				int digit = (digits[i] + carry) % 10; //本位
				carry = (digits[i] + carry) / 10; //进位
				digits[i] = digit;
			}			
		}
		
		if(carry == 0)
			return digits;
		else {
			int[] new_digits = new int[len + 1];
			for (int i = 1; i < new_digits.length; i++) {
				new_digits[i] = digits[i - 1];
			}
			new_digits[0] = carry;
			return new_digits;
		}
	}
}
