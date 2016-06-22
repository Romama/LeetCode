package tree;


/**
 * 判断两棵二叉树是否相同
 * @author Administrator
 *
 */
public class IsSameTree {

	public static void main(String[] args){
		Object[] array = { 1, 2, 3, null,4,5};  
		Object[] array1 = {1,2,3,4,5}; 
		
		//构造出完全二叉树
		TreeNode root = BinaryTree.createBinaryTree(array);
		TreeNode root1 = BinaryTree.createBinaryTree(array1);
		
		System.out.println(isSameTree(root, root1));
	}
	
	/**
	 * 判断两个二叉树是否相同
	 * @param p
	 * @param q
	 * @return
	 * 递归
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
