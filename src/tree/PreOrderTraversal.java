package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 先序遍历二叉树
 * recursive:递归
 * iterative:迭代
 * @author admin
 *
 */
public class PreOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] values = {'a','b','c','d','e','f','g'};
	    TreeNode root = BinaryTree.createBinaryTree(values);
	    preorderTraversal(root);
		
	}
	
	/**
	 * 迭代(即深度优先遍历二叉树)
	 * 先序遍历二叉树
	 * @param root
	 * @return
	 */
    public static List<Object> preorderTraversal(TreeNode root) {
        List<Object> list = new ArrayList<Object>();
        if(root == null)
        	return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
        	TreeNode node = stack.pop();
        	list.add(node.val);
        	if(node.right != null) //先压入右子树
        		stack.push(node.right);
        	if(node.left != null) //再压入左子树
        		stack.push(node.left);
        }
        System.out.println(list);
        return list;
    }
}
