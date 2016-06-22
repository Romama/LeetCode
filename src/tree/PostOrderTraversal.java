package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历非递归
 * 借用堆栈stack
 * @author admin
 *
 */
public class PostOrderTraversal {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] values = {'a','b','c','d','e','f','g'};
	    TreeNode root = BinaryTree.createBinaryTree(values);
	    postOrder(root);
	}
	
	//后序非递归遍历二叉树
	public static List<Object> postOrder(TreeNode root){
		List<Object> list = new ArrayList<Object>();
		if(root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();    
		TreeNode node = root, prev = root; //pre记录上一个已经输出的结点
        while (node != null || stack.size() > 0) {    
            while (node != null) {    
                stack.push(node);    
                node = node.left;    
            }    
            TreeNode temp = stack.peek().right; //在出栈之前，先判断栈顶元素的右孩子结点
            if (temp == null || temp == prev) { //当前节点无右子树或右子树已经输出    
                node = stack.pop();    
                list.add(node.val);
                prev = node; //记录上一个已输出结点
                node = null;    
            } else {    
                node = temp; //处理右子树
            }    
        }
        System.out.println(list);
        return list;
	}
}
