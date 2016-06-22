package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 * 借用队列queue
 * @author admin
 *
 */
public class BreadthFirstSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] values = {'a','b','c','d','e','f','g'};
	    TreeNode root = BinaryTree.createBinaryTree(values);
	    bfs(root);

	}
	
	//广度优先遍历二叉树
	public static void bfs(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>(); //队列需要使用linkedlist来初始化
		if(root == null)
			return;
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
	}

}
