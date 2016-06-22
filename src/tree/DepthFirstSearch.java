package tree;

import java.util.Stack;

/**
 * 深度优先遍历
 * 借用堆栈stack
 * @author admin
 *
 */
public class DepthFirstSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] values = {'a','b','c','d','e','f','g'};
	    TreeNode root = BinaryTree.createBinaryTree(values);
	    dfs(root);
	}
	
	//深度优先遍历二叉树
	public static void dfs(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>(); //借助stack
		if(root == null)
			return;
		stack.push(root);
		while(!stack.isEmpty()){ //若栈非空
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if(node.right != null) //先将右孩子结点压入堆栈
				stack.push(node.right);
			if(node.left != null) //然后将左孩子结点压入堆栈
				stack.push(node.left);
		}
	}

}
