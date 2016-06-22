package arrays;

/**
 * 将数组A和数组B合并到A中
 * 已知：A和B是非递减序列
 * 要求：合并后的A依然是非递减序列
 * @author admin
 *
 */
public class MergeTwoArrays {

	public static void main(String[] args){
		int[] a = {1,3,5,13,17};
		int[] b = {4,7,9,12};
		int[] c = merge(a, b);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
	}
	/**
	 * 将a和b两个非递减序列合并到c中，并返回c
	 * @param a
	 * @param b
	 */
	public static int[] merge(int[] a,int[] b){
		int[] c = {};
		if(a == null || b == null) return c;
		else if(a.length == 0){
			c = b;
			return c;
		} 
		else if(b.length == 0){
			c = a;
			return c;
		}
		
		int len = a.length + b.length;
		c = new int[len]; //给数组c赋值
		int i = 0,j = 0,k = 0;
		while(i < a.length && j < b.length){
			if(a[i] <= b[j])
				c[k++] = a[i++];
			else {
				c[k++] = b[j++];
			}
		}
		
		if(i < a.length)
			while(i < a.length)
				c[k++] = a[i++];
		if(j < b.length)
			while(j < b.length)
				c[k++] = b[j++];
		
		return c;
		
	}
}
