package sortMethods;

/**
 * 冒泡排序(交换排序)
 * 稳定，时间复杂度O(N^2),空间复杂度O(1)
 * @author i333083
 */
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {9,2,30,10,4,8};
		bubbleSort(a);
		for(int j = 0; j < a.length; ++j){
			System.out.print(a[j] + " ");
		}
	}
	
	//冒泡排序
	public static void bubbleSort(int[] a){
		if(a == null || a.length == 0)
			return;
		boolean flag = false; //记录一趟排序中是否有交换。若无交换，说明当前数组已经有序

		for(int i = 0; i < a.length - 1; ++i){ //排序趟数 n-1趟
			for(int j = 0; j < a.length - 1 - i; ++j){
				if(a[j] > a[j + 1]){
					swap(a,j ,j + 1);
					flag = true;
				}
			}
			
			if(!flag)
				break;
		}
			
	}
	
	//交换元素
	public static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
