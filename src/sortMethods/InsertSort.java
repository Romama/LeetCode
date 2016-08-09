package sortMethods;

/**
 * 直接插入排序
 * 稳定，时间复杂度O(N^2)(优化后O(N))，，空间复杂度O(1)
 * @author i333083
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {3,10,9,8,7,38};
		insertSort(a);
		for(int i = 0; i < a.length; ++i)
			System.out.print(a[i] + " ");
	}
	
	public static void insertSort(int[] a){
		if(a == null || a.length == 0)
			return;
		//n-1趟插入
		for(int i = 0; i < a.length - 1; ++i){
			int temp = a[i + 1];
			int k = i;
			for(; k >= 0 && a[k] > temp;--k)
				a[k + 1] = a[k];
			a[k + 1] = temp;
			
			for(int l = 0; l < a.length; ++l)
				System.out.print(a[l] + " ");
			System.out.println();
		}
	}

}
