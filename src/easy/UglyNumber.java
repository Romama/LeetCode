package easy;


/**
 * 将一个整数进行素数分解，若其分解得到的因子中只有2或3或5，而不含有其它素数，则称该数为ugly number，否则不是ugly number。
 * @author admin
 *
 */
public class UglyNumber {

	public static void main(String[] args){
		int num = 17;
		System.out.println(isUgly(num));
	}
	
	/**
	 * 判断一个数是不是ugly number
	 * @param num
	 * @return
	 */
	
	//将num除去2,3,5这三个因子后，应该得到最终结果为1，若不为1，就不是ugly number
	public static boolean isUgly(int num) {
	   if(num <= 0) //题目要求是整数，所以对于非整数一定要进行排除，否则会超时
		   return false;
	   while(num % 2 == 0)//如果存在2的质因子，则将所有2都找出来
           num = num / 2;
       while(num % 3 == 0)//接着找出所有的3
           num = num / 3;
       while(num % 5 == 0)//找出所有的5
           num = num / 5;
       return (num == 1) ;//若除了2,3,5之外，不存在其他质数因子，则为ugly number
 
	}
	
}
