package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求解二叉树的最大深度
 * @author admin
 *
 */
public class MaxDepthOfBT {

	public static void main(String[] args){
		Object[] values = {1,3,6,7,10,2,5,8,9};
		TreeNode root = BinaryTree.createBinaryTree(values);
		System.out.println(maxDepthByDFS(root)); //深度优先遍历
		System.out.println(maxDepthByBFS(root)); //广度优先遍历
	}
	
	/**
	 * DFS
	 * 递归
	 * 记根节点为第1层
	 * @param root
	 */
	public static int maxDepthByDFS(TreeNode root){
		if(root == null)
			return 0;
		int left = maxDepthByDFS(root.left); //左孩子的高度
		int right = maxDepthByBFS(root.right); //右孩子的高度
		return left > right ? left + 1 : right + 1;
	}
	
	/**
	 * BFS
	 * 非递归
	 * 借助队列，最大层次数即为最大深度
	 * 记根节点为第1层
	 * @param root
	 */
	public static int maxDepthByBFS(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int nCount = 1; //当前队列里的结点数目
		int nDepth = 0; //记录树的深度
		queue.add(root); 
		while(!queue.isEmpty()){
			TreeNode node = queue.poll(); //取出队列头部元素
			nCount--;
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
			
			if(nCount == 0){
				nDepth++; //深度加1
				nCount = queue.size();
			}
		}
		return nDepth;
	}
}
