package hard;

/**
 * 打印 1到最大的n位数
 * @author Administrator
 *
 */
public class PrintToMaxOfNDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		//printMaxOfN(n);
		printToMaxOfNDigits_2(n);
	}
	
	/**
	 * 方法一：全排列，效率高些
	 * 打印1到最大的n位数
	 */
	public static void printMaxOfN(int n){
		if(n <= 0)
			return;
		char[] number = new char[n + 1]; //长度为n位
		maxOfNDigitsRecursively(number, n + 1, 0);
	}
	
	/**
	 * 递归
	 * @param number
	 * @param n
	 * @param index
	 */
	public static void maxOfNDigitsRecursively(char[] number,int n,int index){
		if(index == n - 1){
			print(number);
			return;
		}
		
		for(int i = 0; i < 10; ++i){
			number[index] = (char)(i + '0');
			maxOfNDigitsRecursively(number, n, index + 1);
		}
			
	}
	
	/**
	 * 效率低
	 * 方法二：在字符串上模拟加法
	 * @param n
	 */
	public static void printToMaxOfNDigits_2(int n){
		if(n <= 0)
			return;
		char[] number = new char[n]; //长度为n+1，number[0]用来判断是否到达最大值
		for(int i = 0; i < n; ++i)
			number[i] = '9';
		number[0] = '0';
		while(!increment(number)){
			print(number);
		}
	}
	
	/**
	 * 自增1
	 * @param number
	 * @return
	 */
	public static boolean increment(char[] number){
		boolean isOverFlow = false;
		int nTake = 0; //前一位向本位的进位
		int len = number.length;
		for(int i = len - 1; i >= 0; --i){
			int nSum = number[i] - '0' + nTake;//char转换为int，不需要强制转换
			if(i == len - 1){//若为最后一位，加1
				nSum++;
			}
			
			if(nSum >= 10){
				if(i == 0)
					isOverFlow = true;
				else{
					nSum = nSum - 10;
					nTake = 1;
					number[i] = (char)(nSum + '0');//整数转换为字符串时一定要进行强制转换
				}
			} else {
				number[i] = (char)(nSum + '0');
				break;
			}
		}
		
		return isOverFlow;
	}
	
	/**
	 * 打印一个数
	 * @param number
	 */
	public static void print(char[] number){
		StringBuilder sBuilder = new StringBuilder();
		int i = 0,len;
		for(len = number.length; i < len && number[i] == '0'; ++i);
		for(int j = i; j < len; ++j)
		   sBuilder.append(number[j]);
		System.out.print(sBuilder.toString() + " ");
	}

}
