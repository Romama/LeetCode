package sortMethods;

/**
 * 归并排序 mergeSort
 * 稳定，时间复杂度O(NlogN),空间复杂度O(N)
 * @author i333083
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {3,4,6,1,2};
		mergeSort(a,0,a.length - 1);
		for(int i = 0; i < a.length; ++i)
			System.out.print(a[i] + " ");
		
	}
	
	/**
	 * 归并排序
	 * @param a
	 * @param low
	 * @param high
	 */
	public static void mergeSort(int[] a,int low,int high){
		if(low < high){
			int mid = (low + high) / 2;
			mergeSort(a,low,mid);
			mergeSort(a,mid + 1,high);
			merge(a,low,mid,high);
		}
	}
	
	/**
	 * 一次合并
	 * 将两个有序子序列合并为一个有序子序列
	 * @param a
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(int[] a,int low ,int mid,int high){
		int[] temp = new int[high - low + 1]; //辅助数组，存储合并后的有序序列
		int k = 0;
		int i = low,j = mid + 1;
		while(i <= mid && j <= high){
			if(a[i] <= a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		
		while(i <= mid)
			temp[k++] = a[i++];
		while(j <= high)
			temp[k++] = a[j++];
		//将排好序的数组复制回到原数组中
		for(k = 0; k < temp.length; ++k){
			a[low++] = temp[k];
		}
	}

}
