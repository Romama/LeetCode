package tree;


/**
 * 给定一棵二叉树
 * 和一个sum值
 * 判断二叉树上是否有一条路径，使得这个路径上的结点值之和等于sum
 * @author admin
 *
 */
public class PathSum {

	
	public static void main(String[] args){
		 Object[] array = {2,3,1,4,6,7};  //构造二叉树的结点值
		 TreeNode root = BinaryTree.createBinaryTree(array);
		 int sum = 10;
		 System.out.println(hasPathSum(root, sum));
	}
	
	/**
	 * 是否存在一条路径，使得这条路径上的结点值之和为sum
	 * 递归
	 * @param root
	 * @param sum
	 * @return
	 */
    public static boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null)
    		return false;
    	sum = sum - Integer.parseInt(root.val.toString());
    	if(root.left == null && root.right == null)
    		return sum == 0;
    	return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
