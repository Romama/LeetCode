package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 中序遍历二叉树
 * recursive:递归
 * iterative:迭代
 *
 */
public class InOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] values = {'a','b','c','d','e','f','g'};
	    TreeNode root = BinaryTree.createBinaryTree(values);
	    inorderTraversal(root);

	}
	
	/**
	 * 迭代
	 * 中序遍历二叉树
	 * @param root
	 * @return
	 */
	public static List<Object> inorderTraversal(TreeNode root) {
	      List<Object> list = new ArrayList<Object>();
	      if(root == null)
	    	  return  list;
	      Stack<TreeNode> s = new Stack<TreeNode>();
	      TreeNode p = root;
	      while(p != null || !s.isEmpty()){
	    	  while(p != null){
	    		  s.push(p);
	    		  p = p.left;
	    	  }
	    	  p = s.pop();
	    	  list.add(p.val);
	    	  p = p.right;
	      }
	      System.out.println(list);
	      return list;
	}
}
