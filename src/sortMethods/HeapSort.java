package sortMethods;

/**
 * 堆排序
 * 不稳定，时间复杂度O(NlogN),空间复杂度O(1)
 * @author i333083
 *
 */
public class HeapSort {

	public static void main(String[] args){
		int[] a = new int[]{ 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
		heapSort(a);
	}
	
	/**
	 * 交换元素
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void swap(int[] a,int i,int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	/**
	 * @param a 待排数组
	 */
	public static void heapSort(int[] a){
		//n次调整堆，每次获得一个排好序的元素
		for(int i = 0;i < a.length; ++i){
			//maxHeapSort(a,a.length - 1 - i); 
			minHeapSort(a,a.length - 1 - i);
			swap(a,0,a.length - 1 - i);  //将堆顶元素与最后一个元素交换
		}
		//打印
		for(int j = 0; j < a.length; ++j)
			System.out.print(a[j] + " ");
	}
	
	/**
	 * 调整为大根堆
	 * @param a 待排数组
	 * @param lastIndex 待调整的堆中最后一个元素
	 */
	public static void maxHeapSort(int[] a,int lastIndex){
		//从最后一个非叶子节点开始，开始调整堆
		for(int i = (lastIndex - 1) / 2; i >= 0; --i){
			int k = i; //暂存当前要遍历的节点位置
			//调整当前节点下的子树
			while(2 * k + 1 <= lastIndex){//注意：这里是 <= 当最后一个非叶结点只有一个左孩子时 == 成立
				int biggerIndex = 2 * k + 1;
				if(biggerIndex < lastIndex){
					if(a[biggerIndex] < a[biggerIndex + 1])
						biggerIndex = biggerIndex + 1;
				}
				
				//若当前节点小于其孩子节点，则交换元素，并继续对被交过的节点所在子树进行调整
				if(a[k] < a[biggerIndex]){
					swap(a,k,biggerIndex);
					k = biggerIndex; //继续调整以k为根节点的子树
				} else {
					break;
				}
			}
		}
	}
	
	/**
	 * 调整为小根堆
	 * @param a
	 * @param lastIndex
	 */
	public static void minHeapSort(int[] a,int lastIndex){
		for(int i = (lastIndex - 1) / 2; i >= 0; --i){
			int k = i; //暂存当前遍历位置
			while(2 * k + 1 <= lastIndex){
				int smallerIndex = 2 * k + 1;
				//求出左右孩子结点中值较小的一个
				if(smallerIndex < lastIndex){
					if(a[smallerIndex] > a[smallerIndex + 1])
						smallerIndex++;
				}
				if(a[k] > a[smallerIndex]){
					swap(a,k,smallerIndex);
					k = smallerIndex;
				}else{
					break;
				}
			}
		}
	}
}
