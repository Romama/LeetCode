package sortMethods;

/**
 * 快速排序(交换排序)，平均时间效率最高的排序算法
 * 不稳定，平均时间复杂度为O(NlogN)
 * @author i333083
 */
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {3,6,8,2,1,10,9,7};
		quickSort(a,0,a.length - 1);
		for(int i = 0; i < a.length; ++i)
			System.out.print(a[i] + " ");
	}
	
	/**
	 * 快速排序
	 * @param a
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] a,int low,int high){
		if(low < high){//low < high时才需要排序，否则不需要
			int pos = partition(a,low,high); //进行一次划分，pos位置上的元素已经处于最终排序位置，不需要再参与排序
			quickSort(a,low,pos - 1);
			quickSort(a,pos + 1,high);
		}
	}
	
	/**
	 * 一次划分，返回划分的下标
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(int[] a,int low,int high){
		int pivot = a[low]; //一次划分，这里初始定义a[low]为枢轴
		while(low < high){
			while(low < high && a[high] >= pivot) //从右向左开始遍历
				high--;
			a[low] = a[high];
			while(low < high && a[low] < pivot) //从左向右开始遍历
				low++;
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}

}
