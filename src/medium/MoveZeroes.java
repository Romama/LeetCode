package medium;

/**
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * @author admin
 * You must do this in-place without making a copy of the array.
   Minimize the total number of operations.
 */
public class MoveZeroes {

	public static void main(String[] args){
		int nums[] = {0,1,0,3,12};
		move(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}
	
	public static void move(int[] nums){
		if(nums == null || nums.length == 0)
            return;
        int b = 0; //数组中最后一个不为0的num的下标值
        int l = nums.length;
        for(int i = l - 1;i >= 0;i--){//找出数组中最后一个不为0的num
            if(nums[i] != 0){
                b = i;
                break;
            }
        }
        
        for(int i = b - 1; i >= 0;i--){
            if(nums[i] == 0){
                for(int j = i; j < b;j++)
                    nums[j] = nums[j + 1];
                nums[b--] = 0;
            }
        }
	}
}