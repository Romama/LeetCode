package combination_permutation_subset;

import java.util.ArrayList;
import java.util.List;

/**
 * 求一个序列的所有全排序中，第k个排列
 * 
 * @author WeiCuicui
 *
 */
public class KthPermutation {
	
	public static void main(String[] args){
		int n = 3,k = 3;
		System.out.println(getKthPermutation(n, k));
	}

	/**
	 * 方法二：利用阶乘
	 * @param n
	 * @param k
	 * @return
	 */
	public static String getKthPermutation(int n,int k){
		
		//存储数组元素
	    List<Integer> numbers = new ArrayList<Integer>();
	    
	    //存储i个元素有多少种排列
	    int[] factorial = new int[n + 1];
	    StringBuilder sb = new StringBuilder();

	    // create an array of factorial lookup
	    int sum = 1;
	    //设置0个元素有1种排列
	    factorial[0] = 1;
	    for(int i = 1; i <= n; i++){
	        sum *= i;
	        factorial[i] = sum;
	    }
	    // factorial[] = {1, 1, 2, 6, 24, ... n!}

	    // create a list of numbers to get indices
	    for(int i = 1; i <= n; i++){
	        numbers.add(i);
	    }
	    // numbers = {1, 2, 3, 4}

	    
	    // 原数组本身就是一个排列
	    k--;

	    //获取排列中的n个数字
	    for(int i = 1; i <= n; i++){
	        int index = k / factorial[n - i];
	        sb.append(String.valueOf(numbers.get(index)));
	        numbers.remove(index);
	        k-=index*factorial[n-i];
	    }

	    return String.valueOf(sb);
	}
}
