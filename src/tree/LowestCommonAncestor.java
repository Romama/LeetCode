package tree;

import java.util.Queue;
import java.util.Stack;

/**
 * 求最近公共祖先结点
 * @author Administrator
 *
 */
public class LowestCommonAncestor {

	public static void main(String[] args){
		Object[] values = {6,4,8,3,5,7,9}; 
		TreeNode root = BinaryTree.createBinaryTree(values); //构造二叉树
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(3);
		
		//普通二叉树的最近公共祖先
		TreeNode common = LCA_BT(root, p, q);
		if(common != null){
			System.out.println(common.val);
		}
		
		//二叉排序树的最近公共祖先
		TreeNode com = LCA_BST(root,p,q);
		if(com != null)
			System.out.println(com.val);
	}
	
	/**
	 * BT
	 * 解题思路：
	 * 1、首先找到到达p的路径和到达q的路径，将这两个路径存入栈中
	 * 2、然后对两个路径依次出栈，找出第一组，结束
	 * @param root
	 * @return
	 */
	public static TreeNode LCA_BT(TreeNode root,TreeNode p,TreeNode q){
		if(root == null)
			return null;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		TreeNode pre = null;
		//返回true，说明该结点存在；否则，说明给定的结点不存在，则无需再比较
		if(findAllAncestors_BT(root, p.val, s1) && findAllAncestors_BT(root, q.val, s2)){
			while(!s1.isEmpty() && !s2.isEmpty()){
				TreeNode pNode = s1.pop();
				TreeNode qNode = s2.pop();
				if(pNode == qNode){ //查找相同结点
					pre = pNode;
					break; //一旦相同，跳出循环
				}
			}
		}
		return pre;
	}
	
	/** 
	 * BST
	 * 二叉排序树，查找最近公共祖先，递归算法
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode LCA_BST(TreeNode root,TreeNode p,TreeNode q){
		  if (root == null || p == null || q == null) return null;
		  if (Integer.valueOf(p.val.toString()) < Integer.valueOf(root.val.toString()) && Integer.valueOf(q.val.toString()) < Integer.valueOf(root.val.toString())) //两个结点都在左子树
		    return LCA_BST(root.left, p, q);
		  else if (Integer.valueOf(p.val.toString()) > Integer.valueOf(root.val.toString()) && Integer.valueOf(q.val.toString()) > Integer.valueOf(root.val.toString())) //两个结点都在右子树
		    return LCA_BST(root.right, p, q);
		  else
		    return root; //若两个结点一个在左子树上，另一个在右子树上，则共同祖先结点为当前的root
	}
	
	/**
	 * 二叉排序树
	 * 查找结点p的所有祖先结点
	 * @param root
	 * @param p
	 * @param stack
	 */
	public static boolean findAllAncestors_BST(TreeNode root,TreeNode p,Queue<TreeNode> queue){ 
		if(root == null)
			return false;
		if(p.val == root.val){
			queue.add(root);
			return true;
		}
		else if(Integer.valueOf(p.val.toString()) < Integer.valueOf(root.val.toString())){ //在左子树查找
			queue.add(root);
			return findAllAncestors_BST(root.left, p, queue);
		} 
		else {//在右子树查找
			queue.add(root);
			return findAllAncestors_BST(root.right, p, queue);
		}
	}
	
	
	/**
	 * 普通二叉树
	 * 查找节点a的所有祖先节点。
	 * @param root
	 * @param a
	 * @param stack
	 * @return
	 */
	public static boolean findAllAncestors_BT(TreeNode root,Object a,Stack<TreeNode> stack){
		if(root == null)
			return false;
		stack.push(root);
		if(root.val.equals(a)){
			return true;
		}
		//首先在左子树中查找
		boolean result = findAllAncestors_BT(root.left, a, stack);
		
		//若左子树中不存在，在右子树中查找
		if(!result)
			result = findAllAncestors_BT(root.right, a, stack);
		
		//未找到，当前元素不是其祖先结点，将当前元素出栈
		if(!result)
		   stack.pop();
		return result;
	}
}
