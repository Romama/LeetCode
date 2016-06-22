package tree;

/**
 * 判断一个二叉树是不是对称，不能采用中序遍历算法，因为仍然存在不成立的情况。
 * @author Administrator
 *
 */
public class IsSymmetric {
	
	public static void main(String[] args){
		Object[] nodesValue = {'a','b','c','d','e','h','f','g','i'};
		TreeNode root = BinaryTree.createBinaryTree(nodesValue);
		System.out.println(isSymmetric(root)); //判断二叉树是否是对称的
	}
	
	/**
	 * 判断二叉树是否为对称二叉树
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root){
		if(root == null) return true;
		return isMirror(root.left,root.right);
	}
	
	/**
	 * 递归判断一个二叉树的左右是否成镜像
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static boolean isMirror(TreeNode n1,TreeNode n2){
		if(n1 == null && n2 == null) return true; //只有一个根节点，返回true
		if(n1 == null && n2 != null) return false; //左右不对称
		if(n1 != null && n2 == null) return false; //左右不对称
		if(n1.val != n2.val) return false; //不对称
		else return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
	}
}
