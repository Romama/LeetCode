package sortMethods;

/**
 * 直接选择排序
 * 稳定，时间复杂度O(N^2),空间复杂度O(1)
 * 堆排序也是基于选择的排序
 * 
 * @author i333083
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {3,5,6,2,10};
		selectSort(a);
		for(int i = 0; i < a.length; ++i)
		    System.out.print(a[i] + " ");
	}
	
	public static void selectSort(int[] a){
		if(a == null || a.length == 0)
			return;
		 //n趟，每一趟从数组a中找到最大值
		for(int i = 0; i < a.length; ++i){ //i，记录趟数
			//每一趟初始，都将max设置为第一个元素
			int max = a[0]; //记录最大值
			int index = 0; //记录最大值的下标
			for(int j = 0; j < a.length - i; ++j){
				if(a[j] > max){
					max = a[j];
					index = j;
				}
			}
			//交换元素
			if(index != a.length - i - 1){
				a[index] = a[a.length - i - 1];
				a[a.length - i - 1] = max;
			}
	
		}
	}
}
