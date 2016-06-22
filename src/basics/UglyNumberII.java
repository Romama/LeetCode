package basics;

//查找第n个ugly number，其中，1为第一个ugly number
public class UglyNumberII { 

	public static void main(String[] args){
		System.out.println(findTheNthUglyNumber(9));
	}
	
	//动态规划方法
	//根据丑数的定义，丑数应该是另一个丑数乘以2、3或者5的结果（1除外）
	/**
	 * 因此我们可以创建一个数组，里面的数字是排好序的丑数,里面的每一个丑数是前面的丑数乘以2、3或者5得到的。
	 * 关键就是保证数组里面的数字是排好序的。
	 * 假设arr[1..i]是已经排好序的数组，则arr[i]一定是这里面最大的数，那么我们只要去寻找新生成的数字中比arr[i]大的的最小的数。
	 * 新生成的数是由前面的数字*2或*3或*5得到的。我们定义index2为前面数字*2中的所有数字中满足大于arr[i]的最小的数的下标，index3,index5类似定义，
	 * 则应该放在arr[i+1]位置的数字便是min(arr[index2]*2,arr[index3]*3,arr[index5]*5)。
	 * index2，index3，index5是维持动态向前的，不会产生无效搜索，因为当前找的数字一定比原来找的要大，所以从上一次找到的下标开始进行搜索就可以了。
	 * @param num
	 * @return
	 */
	public static int findTheNthUglyNumber(int Mindex){
		int index = 1;
	    int[] arr = new int[Mindex]; //存放排好序的ugly number
	    arr[0] = 1; //最小ugly number
	    int index2 = 0, index3 = 0, index5 = 0;  //index2定义为前面数字*2的所有数字中满足大于arr[i]的最小数的下标，index3和index5的定义类似。
	    while(index < Mindex)
	    {
	        int min = Min(arr[index2] * 2,arr[index3] * 3,arr[index5] * 5);
	        arr[index] = min;
	        while(arr[index2] * 2 <= arr[index]) index2++;
	        while(arr[index3] * 3 <= arr[index]) index3++;
	        while(arr[index5] * 5 <= arr[index]) index5++;
	        index++;
	    }
	    
	   // int ans = arr[Mindex - 1]; //获得第n个ugly number
	    return arr[index - 1 ];
	}
	
	//寻找三者中的最小值
	public static int Min(int a, int b , int c){
	    a = a < b ? a : b;
	    if(c < a) return c;
	    else return a;
	}
}
