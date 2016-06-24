package tree;


/**
 * BBT
 * 平衡二叉树
 * @author admin
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args){
		 Object[] array = { 1, 2, 3, 4, 5, 6, 7 };  //构造二叉树的结点值
		 TreeNode root = BinaryTree.createBinaryTree(array);
		 
		 System.out.println(isBalanced(root));
		 
		 System.out.println(isBalancedBT(root));
	}
	
	/**
	 * 方法一：
	 * 判断一棵二叉树是不是平衡二叉树
	 * （这种方法存在很多重复结点的遍历，效率不高）
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
    
   /**
    * 方法二：
    * 不存在重复遍历结点的情况，判断一个二叉树是不是平衡二叉树
    * @param root
    * @return
    */
    public static boolean isBalancedBT(TreeNode root){
    	return checkBalance(root) == -1 ? false : true;
    }
    
    /**
     * 不求二叉树的高度
     * 递归检查一棵树是不是平衡二叉树
     * @param node
     * @return
     */
    public static int checkBalance(TreeNode node){
    	if (node == null) //空结点，平衡
            return 0;

        int left = checkBalance(node.left); //递归遍历左子树
        if (left == -1) 
            return -1;

        int right = checkBalance(node.right); //递归遍历右子树
        if (right == -1) 
            return -1;

        if (left - right > 1 || right - left > 1) //不平衡，返回-1
            return -1; 

        return (left > right ? left : right) + 1;  //若平衡，返回当前结点的高度
    }

}
