package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历二叉树
 * 按照层次依次输出结点值
 * @author admin
 *
 */
public class LevelSearchBT {

	public static void main(String[] args){
		Object[] values = {1,3,6,7,10,2,5,8,9};
		TreeNode root = BinaryTree.createBinaryTree(values);
		levelSearch(root);
		
		System.out.println("\n" + levelSearch_list(root));
	}
	
	/**
	 * 层次遍历二叉树
	 * 按照层次输出二叉树中的结点
	 * @param root
	 */
	public static void levelSearch(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int nCount = 1; //记录每一层中的结点个数
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			nCount--;
			System.out.print(node.val + " ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
			if(nCount == 0){ //输出完一层后，重新赋值nCount为新的一层中的结点个数
				System.out.println();
				nCount = queue.size();
			}
		}
	}
	
	/**
	 * 层次遍历二叉树
	 * 返回按照层次统计的每一层的结点值
	 * @param root
	 */
	public static List<List<Object>> levelSearch_list(TreeNode root){
		List<List<Object>> list = new ArrayList<List<Object>>();
		if(root == null)
			return list;
		List<Object> nLevel = new ArrayList<Object>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int nCount = 1; //记录每一层中的结点个数
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			nCount--;
			System.out.print(node.val + " ");
			nLevel.add(node.val);
			
			if(node.left != null){
				queue.add(node.left);
				
			}
			if(node.right != null){
				queue.add(node.right);
				
			}
			if(nCount == 0){ //输出完一层后，重新赋值nCount为新的一层中的结点个数
				nCount = queue.size();
				list.add(nLevel);
				nLevel = new ArrayList<Object>();
			}
			
		}
		
		return list;
	}
}
