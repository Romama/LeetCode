package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

	static List<List<Integer>> result = new ArrayList<List<Integer>>();  //结果集
    static List<Integer> path = new ArrayList<Integer>();  //结果集中的单个列表
	
	
	public static void main(String[] args){
		 Object[] array = {0,1,1};  //构造二叉树的结点值
		 TreeNode root = BinaryTree.createBinaryTree(array);
		 int sum = 1;
		 System.out.println(pathSumNew(root, sum));
		 //System.out.println(pathSumNew(root, sum));
	}
	
	/**
	 * 返回和为sum的路径集合
	 * @param root
	 * @param sum
	 * @return
	 */
	public static List<List<Integer>> pathSumNew(TreeNode root, int sum) {  
	     //getSum(root, 0, sum);  
		 getPath(root,sum);
	     return result;  
	}  
	
	/**
	 * 方法一：getSum(TreeNode root, int sum, int target)，增加sum参数，初始化为0
	 * 增加参数sum，统计遍历到当前结点时所经过路径上所有结点值的和
	 * 当遍历到叶子结点时，if(sum == target)，说明找到一条路径
	 * @param root
	 * @param sum
	 * @param target
	 */
    public static void getSum(TreeNode root, int sum, int target){  
        if(root == null) return;  
        sum += Integer.parseInt(root.val.toString());  
        path.add(Integer.parseInt(root.val.toString()));  
        if(root.left == null && root.right == null && sum == target)  {
        	 List<Integer> pathNew = new ArrayList<Integer>(path); 
        	 result.add(pathNew);  
        }
        getSum(root.left, sum, target);  
        getSum(root.right, sum, target);  
        sum -= Integer.parseInt(root.val.toString());  
        path.remove(path.size() - 1);  
        return;  
    }  
    
    /**
     * 方法二：getPath(TreeNode root, int sum)
     * @param root
     * @param sum
     * @return
     */
    public static void getPath(TreeNode root, int sum){  
    	if(root == null)
    		return;
    	sum = sum - Integer.parseInt(root.val.toString());
    	path.add(Integer.parseInt(root.val.toString()));
    	
    	if(root.left == null && root.right == null && sum == 0){ //找到一条路径
    		List<Integer> newpath = new ArrayList<Integer>(path);
			result.add(newpath);
    	} 
    	
    	getPath(root.left, sum); //遍历左子树
    	getPath(root.right, sum); //遍历右子树
    	
    	//恢复sum和path变量
    	sum = sum + Integer.parseInt(root.val.toString()); 
    	path.remove(path.size() - 1);
    	
    	return;
    }  
}
