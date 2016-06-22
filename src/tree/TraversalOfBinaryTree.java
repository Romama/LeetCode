package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的遍历
 * 前序、中序、后序。（深度优先）
 * 层序（广度优先）
 * @author Administrator
 *
 */
public class TraversalOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] nodesValue = {'a','b','c','d','e',null,'h',null,null,'f','g',null,null,'i'};
		TreeNode root = BinaryTree.createBinaryTree(nodesValue);
		System.out.println();
		
		levelOrder(root); //层序遍历二叉树
		System.out.println();
		
		preOrder(root);
		System.out.println();
		
		inOrder(root);
		System.out.println();
		
		postOrder(root);
	}
	
	/**
	 * 层序遍历二叉树
	 * 按层次输出节点值
	 * 队列queue，先入先出
	 * @param root
	 */
	public static void levelOrder(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>(); //队列Queue是由linkedlist来初始化的
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll(); //retrieve and remove
			System.out.print(node.val + " ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
	}
	
	//先序遍历二叉树
	public static void preOrder(TreeNode root){
		if(root != null){
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	//中序遍历二叉树
	public static void inOrder(TreeNode root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}
	
	//后序遍历二叉树
	public static void postOrder(TreeNode root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val + " ");
		}
	}

}
