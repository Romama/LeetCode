package basics;
/**
 * 台阶一共高n，每次走一阶或者两阶，问有多少种不同的爬楼梯方式
 * @author admin
 *
 */
public class ClimbingStairs {

	public static void main(String[] args){
		
		//使用递归
		System.out.println(climbs(4));
		//使用循环
		System.out.println(clims1(10));
	}
	
	//找规律，设n个台阶的方法数为f(n)
	//f(1) = 1;f(2) = 2; .... ,从第n-1走到第n台阶，有两种方式：一步到或者两步到。
	//因此，f(n) = f(n-1) + f(n-2); (n >= 3)
	//递归运算，时间复杂度太高
	public static int climbs(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		return climbs(n - 1) + climbs(n - 2);
	}
	
	//时间复杂度 O(n)，空间复杂度O(1)
	public static int clims1(int n){
		if(n == 0)
			return 0;
		int prev = 0;  //prev = f(n-2)
        int cur = 1;   //cur = f(n-1)
        for(int i = 1; i <= n ; ++i){
            int tmp = cur;
            cur = prev + cur; // f(n) = f(n-2) + f(n-1)
            prev = tmp;
        }
        return cur;
	}
}
