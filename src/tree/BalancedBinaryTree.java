package tree;

/**
 * BBT
 * 平衡二叉树
 * @author admin
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args){
		 Object[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  //构造二叉树的结点值
		 TreeNode root = BinaryTree.createBinaryTree(array);
		 System.out.println(isBalanced(root));
		 
	}
	
	/**
	 * 判断一棵二叉树是不是平衡二叉树
	 * BBT
	 * 递归
	 * 通过二叉树的高度进行比较
	 * @param root
	 * @return
	 */
	 public static boolean isBalanced(TreeNode root) {
	        if(root == null) //若为null，平衡
	        	return true;
	        int left = depthOfBT(root.left);
		    int right = depthOfBT(root.right);
		    if((left - right > 1) || (right - left > 1)){ //若左右子树中存在不平衡的，则不平衡
		    	return false;
		    } else {
		    	return isBalanced(root.left) && isBalanced(root.right); //递归判断左右子树是否平衡
			}
	 }
    
    /**
     * 求二叉树的高度
     * @param root
     * @return
     */
    public static int depthOfBT(TreeNode root){
    	if(root == null)
    		return 0;
    	int left = depthOfBT(root.left);
    	int right = depthOfBT(root.right);
    	return left > right ? left + 1 : right + 1;
    }

}
