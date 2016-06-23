package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 求二叉树的深度
 * @author WeiCuicui
 *
 */
public class DepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 方法一：
	 * 递归求二叉树的深度
	 * @return
	 */
	public static int depthRecursive(TreeNode root){
		if(root == null)
			return 0;
		int left = depthRecursive(root.left);
		int right = depthRecursive(root.right);
		
		return left > right ? left + 1 : right + 1;
	}
	
	/**
	 * 方法二：
	 * 受后根遍历算法的启发，求二叉树的深度
	 * @param root
	 * @return
	 */
	public static int depthIteration(TreeNode root){
	
		if(root == null)
			return 0;
		int maxDepth = 0; //记录当前结点的最大深度
		TreeNode pre = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p != null || !stack.isEmpty()){
			while(p != null){
				stack.push(p);
				p = p.left;
			}
			
			TreeNode node = stack.peek().right;
			if(pre == node || node == null){//右子树已经遍历或没有右子树
				
			}
		}

	}
	
	/**
	 * 方法三：
	 * 受层序遍历算法的启发，求出二叉树有多少层，也就知道了二叉树的高度是多少
	 * @param root
	 * @return
	 */
	public static int depthLevelTraversal(TreeNode root){
		if(root == null)
			return 0;
		int count = 1;
		int depth = 0; //深度
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			count--;
			if(count == 0)
				depth++;
			
			if(node.left != null){
				queue.add(node.left);
				count++;
			}
				
			if(node.right != null){
				queue.add(node.right);
				count++;
			}	
		}
		
		return depth;
	}

}
