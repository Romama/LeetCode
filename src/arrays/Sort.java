package arrays;


/**
 * 排序算法
 * @author Administrator
 *
 */
public class Sort {
	public static void main(String[] args){
		int[] array = {3,2,8,0,9,0,7,6};
		int left = 0,right = array.length - 1;
		//快速排序
		shellSort(array);
		//bubble_1(array);
		//mergeSort(array, 0, right);
		//quickSort(array, left, right);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	//快速排序（不稳定）
	public static void quickSort(int[] nums,int left,int right){
        
        if(left < right){
        	//划分位置
        	int dp = partition(nums, left, right); //最终位置 dp
        	quickSort(nums, left, dp - 1); //dp - 1
        	quickSort(nums, dp + 1, right); //dp + 1
        }
	}
	//快速排序之划分
	public static int partition(int[] nums,int left,int right){
		int pivot = nums[left];
		while(left < right){
			while(left < right && nums[right] >= pivot)//从右到左
				right--;
			nums[left] = nums[right];
			while(left < right && nums[left] < pivot)//从左到右
				left++;
			nums[right] =nums[left];
		}
		nums[left] = pivot;
		return left;
	}

	//希尔排序，是对直接插入排序的改进（不稳定）
	public static void shellSort(int[] a){
		
		int d = a.length;
		while(true) {
			d = d / 2;
			for(int x = 0; x < d; x++){
				for(int i = x + d; i < a.length; i = i + d){
					int tmp = a[i];
					int j = i - d;
					for(; j >= 0 && a[j] > tmp; j = j - d)
						a[j + d] = a[j];
					a[j + d] = tmp;
				}
			}
			
			if(d == 1) //已经进行了最后一趟排序了，数组已经排好序，结束，跳出循环
				break;
		}
	}
	
	//冒泡排序算法（稳定）
	public static void bubble(int[] nums){
		if(nums == null || nums.length == 0)
			return;
		int len = nums.length;
		
		for(int i = 0; i < len - 1 ; i++){//趟数
			boolean flag = false;
			for(int j = 1 ;j < len - i;j++){
				if(nums[j - 1] > nums[j]){
					flag = true;
					int tmp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = tmp;
				}
			}
			if(!flag)//一趟排序中并没有交换元素，说明已经排好序
				break;
		}	
	}
	
	//直接插入排序算法(对于总体上是有序的数组，或 数组长度较小的数组，排序效率是最高的) （稳定）
	public static void insertSort(int[] arr){
		int tmp;
		int n = arr.length;
		for(int i = 1; i <= n - 1; i++){ //n-1次插入,第一个元素是排好序的
			tmp = arr[i]; //暂存元素
			int j = i - 1;
			for(; j >= 0 && arr[j] > tmp;j--) //移动元素
				arr[j + 1] = arr[j];
			arr[j + 1] = tmp; //插入元素
		}
	}
	
	 /**
     * 简单选择排序法：（不稳定）
     * 每次从剩余元素中选择一个最小值，交换最小值与数组中相应位置上的数值 n趟
     * 时间复杂度：O(n*n)（所有情况下的时间复杂度是相同的，没有什么区别）
     * @param nums
     */
    public static void simpleSelectSort(int[] nums){
        
        for(int i = 0;i < nums.length - 1;i++){ //趟数
            int k = i; //暂存当前位置
            int min = nums[i]; //暂存当前元素
            //查找剩余元素中的最小值
            for(int j = i + 1; j < nums.length;j++){
                if(nums[j] < min){
                    min = nums[j];
                    k = j;
                }
            }
            
            //交换元素，根据元素下标来交换元素
            if(i != k){
                nums[k] = nums[i];
                nums[i] = min;
            }    
        }
    }
    //归并排序算法（稳定）
    public static void mergeSort(int[] nums,int low, int high){
    	if(low < high){
    		int mid = (low + high) / 2; //平分数组
    		mergeSort(nums, low, mid); //递归对左半边进行归并排序
    		mergeSort(nums, mid + 1, high); //递归对右半边进行归并排序
    		merge(nums,low,mid,high); //合并
    	}
    }
    //合并两个有序序列
    public static int[] merge(int[] nums,int low, int mid, int high){
    	int len = high - low + 1;
    	int[] tmp = new int[len]; //辅助数组，存储合并后的有序序列
    	int i = 0,left = low,right = mid + 1;
    	while(left <= mid && right <= high){
    		if(nums[left] <= nums[right]){
    			tmp[i++] = nums[left++];
    		} else {
				tmp[i++] = nums[right++];
			}
    	}
    	while(left <= mid)
    		tmp[i++] = nums[left++];
    	while(right <= high)
    		tmp[i++] = nums[right++];
    	for(int j = 0; j < tmp.length; j++){//将合并后的序列复制回原数组
    		nums[j + low] = tmp[j];
    	}
    	return nums;
    }

}