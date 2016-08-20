package easy;


/**
 * 鸽巢原理的证明
 * 假设有 n+1个数，每个数的范围都是1-n，则这n+1个数中一定存在重复元素。
 * 假设只有一个数是重复存在的，找出这个重复的元素。
 * 方法：
 * （1）排序，很容易找出这个重复的元素
 * （2）利用鸽巢原理的概念进行证明，
 * @author Administrator
 *
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args){
		int[] nums = {1,9,3,8,2,5,6,6,7,4};
		System.out.println(findDuplicate(nums));
		System.out.println(findDuplicateSort(nums));
	}
	
	//排序法
	public static int findDuplicateSort(int[] nums){
		int len = nums.length;
		quickSort(nums,0,len - 1); //快速排序
		for(int i = 1; i < len; i++)
			if(nums[i] == nums[i - 1] )
				return nums[i];
		return -1;
	}
	
	//二分查找 ：若小于mid的数有mid个，则在upperPart查找，否则，在lowerPart查找
	public static int findDuplicate(int[] nums){
		int n = nums.length - 1; // 总共 n+1 个元素
		int low = 1; //数组中可能的最小值
		int high = n; //数组中可能的最大值
		int mid = 0; 
		while(low < high){
			mid = low + (high - low) / 2; //取中间值
			int c = count(mid, nums); //统计小于mid的元素
			if(c <= mid){//重复值应该在upperPart
				low = mid + 1;
			}else { //重复值应该在lowerPart
				high = mid - 1;
			}
		}
		return low;
	}
	
	public static int count(int mid,int[] nums){
		int c = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] <= mid)
				c++;
		}
		return c;
	}
	
    public static void quickSort(int[] nums,int left,int right){
    	if(left < right){
    		int pivot = nums[left];
    		int low = left;
    		int high = right;
    		while(low < high){//partition
    			while(low < high && nums[high] > pivot)
    				high--;
    			nums[low] = nums[high];
    			
    			while(low < high && nums[low] <= pivot)
    				low++;
    			nums[high] = nums[low];
    		}
    		
    		nums[low] = pivot; //low 就是 pivot排序后的最终位置
    		quickSort(nums, left, low - 1);
    		quickSort(nums, low + 1, right);
    	}
    }

}
